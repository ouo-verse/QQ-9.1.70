package com.tencent.mobileqq.widget.search;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.collection.QQConcurrentHashMap;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SearchController {
    private static final int HASHMAP_QUI_SEARCHBAR = 1025;
    private static final String TAG = "SearchController";
    private static final QQConcurrentHashMap<Integer, SearchController> sMap = new QQConcurrentHashMap<>(Business.Default, TAG);
    private boolean isInRecruit;
    private final int mChainKey;
    private final LinkedHashMap<Integer, WeakReference<ISupportAction>> mItemsOnChain = new LinkedHashMap<>();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface ISupportAction {
        void doBackAction();

        void doCancelAction();

        Context getAttachContext();
    }

    SearchController(int i3) {
        this.mChainKey = i3;
    }

    public static void defaultBackAction(@NonNull ISupportAction iSupportAction, @Nullable SearchController searchController) {
        if (searchController != null) {
            searchController.doBack(iSupportAction);
            return;
        }
        Context attachContext = iSupportAction.getAttachContext();
        if (attachContext instanceof Activity) {
            ((Activity) attachContext).onBackPressed();
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "defaultBackAction default consume fail. not activity\uff01" + attachContext);
        }
    }

    public static void defaultCancelAction(@NonNull ISupportAction iSupportAction, @Nullable SearchController searchController, boolean z16) {
        if (searchController != null) {
            searchController.doCancel(iSupportAction, z16);
            return;
        }
        if (!z16) {
            Context attachContext = iSupportAction.getAttachContext();
            if (attachContext instanceof Activity) {
                ((Activity) attachContext).onBackPressed();
            } else if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "defaultCancelAction default consume fail. not activity\uff01" + attachContext);
            }
        }
    }

    private void doBack(@NonNull ISupportAction iSupportAction) {
        defaultBackAction(iSupportAction, null);
        if (this.isInRecruit) {
            return;
        }
        this.mItemsOnChain.remove(Integer.valueOf(iSupportAction.hashCode()));
    }

    private void doCancel(@NonNull ISupportAction iSupportAction, boolean z16) {
        if (!this.isInRecruit) {
            this.mItemsOnChain.remove(Integer.valueOf(iSupportAction.hashCode()));
            this.isInRecruit = true;
            Iterator<Map.Entry<Integer, WeakReference<ISupportAction>>> it = this.mItemsOnChain.entrySet().iterator();
            while (it.hasNext()) {
                ISupportAction iSupportAction2 = it.next().getValue().get();
                if (iSupportAction2 == null) {
                    it.remove();
                } else if (isDependDestroy(iSupportAction2.getAttachContext())) {
                    it.remove();
                } else {
                    iSupportAction2.doCancelAction();
                }
            }
            this.isInRecruit = false;
        }
        defaultCancelAction(iSupportAction, null, z16);
    }

    public static SearchController getInstance(int i3) {
        QQConcurrentHashMap<Integer, SearchController> qQConcurrentHashMap = sMap;
        SearchController searchController = qQConcurrentHashMap.get(Integer.valueOf(i3));
        if (searchController == null) {
            SearchController searchController2 = new SearchController(i3);
            qQConcurrentHashMap.put(Integer.valueOf(i3), searchController2);
            return searchController2;
        }
        return searchController;
    }

    private boolean isDependDestroy(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return true;
            }
        }
        return false;
    }

    public void addNodeView(@NonNull ISupportAction iSupportAction) {
        if (this.isInRecruit) {
            return;
        }
        this.mItemsOnChain.remove(Integer.valueOf(iSupportAction.hashCode()));
        this.mItemsOnChain.put(Integer.valueOf(iSupportAction.hashCode()), new WeakReference<>(iSupportAction));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearNodeView() {
        sMap.remove(Integer.valueOf(this.mChainKey));
        if (this.isInRecruit) {
            return;
        }
        this.mItemsOnChain.clear();
    }

    public int getChainKey() {
        return this.mChainKey;
    }

    public void removeNodeView(@NonNull ISupportAction iSupportAction) {
        if (this.isInRecruit) {
            return;
        }
        this.mItemsOnChain.remove(Integer.valueOf(iSupportAction.hashCode()));
        if (this.mItemsOnChain.isEmpty()) {
            sMap.remove(Integer.valueOf(this.mChainKey));
        }
    }

    public void setAnchorView(@NonNull ISupportAction iSupportAction) {
        if (this.isInRecruit) {
            return;
        }
        this.mItemsOnChain.clear();
        this.mItemsOnChain.put(Integer.valueOf(iSupportAction.hashCode()), new WeakReference<>(iSupportAction));
    }
}
