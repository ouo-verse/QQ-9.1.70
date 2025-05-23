package com.tencent.mobileqq.vas.api.impl;

import android.R;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasColorNoteApi;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016R6\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0011`\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasColorNoteApiImpl;", "Lcom/tencent/mobileqq/vas/api/IVasColorNoteApi;", "", "title", QQWinkConstants.TAB_SUBTITLE, "picUrl", "", "type", "openUrl", "", "showColorNote", "removeColorNote", "", "isColorNoteExist", "isDisplay", "displayColorNote", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/colornote/api/IColorNoteController;", "Lkotlin/collections/HashMap;", "colorNoteControllers", "Ljava/util/HashMap;", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasColorNoteApiImpl implements IVasColorNoteApi {

    @NotNull
    public static final String TAG = "VasColorNoteApiImpl";

    @NotNull
    private HashMap<Integer, IColorNoteController> colorNoteControllers = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/vas/api/impl/VasColorNoteApiImpl$b", "Lcom/tencent/mobileqq/colornote/g;", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b extends com.tencent.mobileqq.colornote.g {
        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ColorNote showColorNote$lambda$2$lambda$0(int i3, String openUrl, String title, String subTitle, String picUrl) {
        Intrinsics.checkNotNullParameter(openUrl, "$openUrl");
        Intrinsics.checkNotNullParameter(title, "$title");
        Intrinsics.checkNotNullParameter(subTitle, "$subTitle");
        Intrinsics.checkNotNullParameter(picUrl, "$picUrl");
        if (i3 > 1) {
            return new ColorNote.a().g(R.id.background).i(openUrl).d(title).h(subTitle).e(picUrl).f(null).a();
        }
        return new ColorNote.a().g(R.layout.activity_list_item).i(TAG).d(title).h("").e("").f(null).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showColorNote$lambda$2$lambda$1(Ref.ObjectRef controller, boolean z16) {
        Intrinsics.checkNotNullParameter(controller, "$controller");
        if (!((IColorNoteController) controller.element).isColorNoteExist()) {
            ((IColorNoteController) controller.element).insertColorNote();
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasColorNoteApi
    public void displayColorNote(boolean isDisplay) {
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, isDisplay);
        QLog.d(TAG, 1, "displayColorNote " + isDisplay);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasColorNoteApi
    public boolean isColorNoteExist(int type) {
        boolean z16;
        IColorNoteController iColorNoteController = this.colorNoteControllers.get(Integer.valueOf(type));
        if (iColorNoteController != null) {
            z16 = iColorNoteController.isColorNoteExist();
        } else {
            z16 = false;
        }
        QLog.d(TAG, 1, "isColorNoteExist " + type + ", result: " + z16);
        return z16;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasColorNoteApi
    public void removeColorNote(int type) {
        IColorNoteController iColorNoteController = this.colorNoteControllers.get(Integer.valueOf(type));
        if (iColorNoteController != null) {
            iColorNoteController.deleteColorNote();
        }
        this.colorNoteControllers.remove(Integer.valueOf(type));
        QLog.d(TAG, 1, "removeColorNote " + type);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, com.tencent.mobileqq.qroute.QRouteApi] */
    @Override // com.tencent.mobileqq.vas.api.IVasColorNoteApi
    public void showColorNote(@NotNull final String title, @NotNull final String subTitle, @NotNull final String picUrl, final int type, @NotNull final String openUrl) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        Intrinsics.checkNotNullParameter(openUrl, "openUrl");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? r16 = this.colorNoteControllers.get(Integer.valueOf(type));
        objectRef.element = r16;
        if (r16 == 0) {
            ?? api = QRoute.api(IColorNoteController.class);
            objectRef.element = api;
            IColorNoteController iColorNoteController = (IColorNoteController) api;
            iColorNoteController.init(BaseApplication.getContext(), false, false);
            iColorNoteController.setServiceInfo(new com.tencent.mobileqq.colornote.f() { // from class: com.tencent.mobileqq.vas.api.impl.aa
                @Override // com.tencent.mobileqq.colornote.f
                public final ColorNote getColorNote() {
                    ColorNote showColorNote$lambda$2$lambda$0;
                    showColorNote$lambda$2$lambda$0 = VasColorNoteApiImpl.showColorNote$lambda$2$lambda$0(type, openUrl, title, subTitle, picUrl);
                    return showColorNote$lambda$2$lambda$0;
                }
            });
            iColorNoteController.disableToast();
            iColorNoteController.setServiceSyncListener(new com.tencent.mobileqq.colornote.smallscreen.o() { // from class: com.tencent.mobileqq.vas.api.impl.ab
                @Override // com.tencent.mobileqq.colornote.smallscreen.o
                public final void onServiceSyncSucc(boolean z16) {
                    VasColorNoteApiImpl.showColorNote$lambda$2$lambda$1(Ref.ObjectRef.this, z16);
                }
            });
            iColorNoteController.registerBroadcast();
            iColorNoteController.setOnColorNoteCurdListener(new b());
            this.colorNoteControllers.put(Integer.valueOf(type), objectRef.element);
        }
        ((IColorNoteController) objectRef.element).insertColorNote();
        QLog.d(TAG, 1, "showColorNote " + type);
    }
}
