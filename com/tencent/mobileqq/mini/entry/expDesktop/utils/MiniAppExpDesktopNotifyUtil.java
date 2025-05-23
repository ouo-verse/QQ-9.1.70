package com.tencent.mobileqq.mini.entry.expDesktop.utils;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.utils.MiniAppExpDesktopNotifyUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/utils/MiniAppExpDesktopNotifyUtil;", "", "()V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public class MiniAppExpDesktopNotifyUtil {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long NOTIFY_DELAY_TIME = 100;
    private static final String TAG = "MiniAppExpDesktopNotifyUtil";

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\u0007\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fJ\u001c\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/utils/MiniAppExpDesktopNotifyUtil$Companion;", "", "()V", "NOTIFY_DELAY_TIME", "", "TAG", "", "removeNullMiniAppForFixError", "", "miniAppInfos", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopGroupAppInfo;", "desktopGroupAppInfoList", "", "safeNotifyDataSetChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void safeNotifyDataSetChanged$lambda$0(RecyclerView.Adapter adapter) {
            Intrinsics.checkNotNullParameter(adapter, "$adapter");
            adapter.notifyDataSetChanged();
        }

        public final void removeNullMiniAppForFixError(List<ExpDesktopGroupAppInfo> desktopGroupAppInfoList) {
            Intrinsics.checkNotNullParameter(desktopGroupAppInfoList, "desktopGroupAppInfoList");
            try {
                if (desktopGroupAppInfoList.isEmpty()) {
                    QLog.i(MiniAppExpDesktopNotifyUtil.TAG, 1, "not need removeNullMiniAppForFixError!");
                    return;
                }
                Iterator<T> it = desktopGroupAppInfoList.iterator();
                while (it.hasNext()) {
                    MiniAppExpDesktopNotifyUtil.INSTANCE.removeNullMiniAppForFixError((ExpDesktopGroupAppInfo) it.next());
                }
            } catch (Exception e16) {
                QLog.e(MiniAppExpDesktopNotifyUtil.TAG, 1, "removeNullMiniAppForFixError error!", e16);
            }
        }

        public final void safeNotifyDataSetChanged(RecyclerView recyclerView, final RecyclerView.Adapter<?> adapter) {
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            if (recyclerView != null) {
                if (recyclerView.isComputingLayout()) {
                    recyclerView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.utils.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            MiniAppExpDesktopNotifyUtil.Companion.safeNotifyDataSetChanged$lambda$0(RecyclerView.Adapter.this);
                        }
                    }, 100L);
                } else {
                    adapter.notifyDataSetChanged();
                }
            }
        }

        Companion() {
        }

        public final void removeNullMiniAppForFixError(ExpDesktopGroupAppInfo miniAppInfos) {
            Intrinsics.checkNotNullParameter(miniAppInfos, "miniAppInfos");
            Iterator<DesktopAppInfo> it = miniAppInfos.getGroupAppInfo().iterator();
            Intrinsics.checkNotNullExpressionValue(it, "miniAppInfos.getGroupAppInfo().iterator()");
            while (it.hasNext()) {
                DesktopAppInfo next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                if (next.mMiniAppInfo == null) {
                    it.remove();
                    QLog.i(MiniAppExpDesktopNotifyUtil.TAG, 1, "removeNullMiniAppForFixError remove null item!");
                }
            }
        }
    }
}
