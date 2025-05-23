package com.qzone.reborn.albumx.qzonex.part.albumdetail;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.util.LoadingUtil;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u00020\n0.\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J0\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010H\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0003H\u0002J\b\u0010\u0019\u001a\u00020\u0003H\u0002J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0006\u0010 \u001a\u00020\u0003J\u000e\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!J&\u0010(\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\u001a2\b\u0010%\u001a\u0004\u0018\u00010\u000f2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\"\u0010-\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016R\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\n0.8\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001b\u0010?\u001a\u00020&8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\u00a8\u0006B"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/albumdetail/QZAlbumxAlbumDetailSharePart;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$c;", "", "Q9", "K9", "", "tips", "W9", "J9", "Lic/b;", "shareContext", "", "action", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "Lkotlin/collections/ArrayList;", "list", "I9", "Lnc/y;", "M9", "T9", "Lnc/u;", "O9", "V9", "P9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "L9", "Lxa/c;", "rsp", "U9", "view", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "w6", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;", "d", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;", "getMShareManager", "()Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;", "mShareManager", "e", "Ljava/lang/String;", "TAG", "Landroid/app/Dialog;", "f", "Landroid/app/Dialog;", "loadingDialog", tl.h.F, "Lkotlin/Lazy;", "N9", "()Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "mSASBuilder", "<init>", "(Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxAlbumDetailSharePart extends com.qzone.reborn.base.k implements ShareActionSheet.c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QQShareActionManager<ic.b> mShareManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String TAG;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Dialog loadingDialog;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy mSASBuilder;

    public QZAlbumxAlbumDetailSharePart(QQShareActionManager<ic.b> mShareManager) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mShareManager, "mShareManager");
        this.mShareManager = mShareManager;
        this.TAG = "QZAlbumxAlbumDetailSharePart";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ShareActionSheet>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxAlbumDetailSharePart$mSASBuilder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ShareActionSheet invoke() {
                ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
                param.context = QZAlbumxAlbumDetailSharePart.this.getActivity();
                return ShareActionSheetFactory.create(param);
            }
        });
        this.mSASBuilder = lazy;
    }

    private final void I9(ic.b shareContext, int action, ArrayList<ShareActionSheetBuilder.ActionSheetItem> list) {
        com.qzone.reborn.albumx.common.share.a<ic.b> c16 = this.mShareManager.c(action);
        if (c16 != null && c16.f(shareContext)) {
            ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(action);
            build.visibility = c16.e() ? 0 : 8;
            list.add(build);
        }
    }

    private final void J9() {
        MutableLiveData<xa.c> U1;
        xa.c value;
        nc.u O9 = O9();
        if (O9 == null) {
            return;
        }
        T9();
        if (!O9.getIsLoadingFinish()) {
            V9();
            return;
        }
        nc.u O92 = O9();
        if (O92 == null || (U1 = O92.U1()) == null || (value = U1.getValue()) == null || value.getCooperation.qzone.QzoneIPCModule.RESULT_CODE java.lang.String() != 0) {
            return;
        }
        U9(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9() {
        MutableLiveData<CommonAlbumInfo> M1;
        CommonAlbumInfo value;
        nc.y M9 = M9();
        if (M9 == null || (M1 = M9.M1()) == null || (value = M1.getValue()) == null) {
            return;
        }
        int permissionType = value.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getPermissionType();
        if (permissionType != 1) {
            if (permissionType != 8 && permissionType != 4) {
                if (permissionType == 5) {
                    String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.b5l);
                    Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_alb\u2026re_question_tips_content)");
                    W9(a16);
                    return;
                } else if (permissionType != 6) {
                    return;
                }
            }
            String a17 = com.tencent.biz.qqcircle.utils.h.a(R.string.app);
            Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qzone_alb\u2026share_limit_tips_content)");
            W9(a17);
            return;
        }
        String a18 = com.tencent.biz.qqcircle.utils.h.a(R.string.azp);
        Intrinsics.checkNotNullExpressionValue(a18, "qqStr(R.string.qzone_alb\u2026hare_public_tips_content)");
        W9(a18);
    }

    private final nc.y M9() {
        l9.c cVar = (l9.c) RFWIocAbilityProvider.g().getIocInterface(l9.c.class, getPartRootView(), null);
        com.qzone.reborn.albumx.common.viewmodel.b Ne = cVar != null ? cVar.Ne() : null;
        if (Ne instanceof nc.y) {
            return (nc.y) Ne;
        }
        return null;
    }

    private final nc.u O9() {
        return (nc.u) getViewModel(nc.u.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9() {
        Dialog dialog;
        Dialog dialog2 = this.loadingDialog;
        if (dialog2 != null) {
            boolean z16 = false;
            if (dialog2 != null && !dialog2.isShowing()) {
                z16 = true;
            }
            if (z16 || (dialog = this.loadingDialog) == null) {
                return;
            }
            dialog.dismiss();
        }
    }

    private final void Q9() {
        MutableLiveData<xa.c> U1;
        MutableLiveData<Boolean> H2;
        nc.y M9 = M9();
        if (M9 != null && (H2 = M9.H2()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxAlbumDetailSharePart$onInitData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean it) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (it.booleanValue()) {
                        QZAlbumxAlbumDetailSharePart.this.K9();
                    } else {
                        QZAlbumxAlbumDetailSharePart.this.L9();
                    }
                }
            };
            H2.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.ao
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZAlbumxAlbumDetailSharePart.R9(Function1.this, obj);
                }
            });
        }
        nc.u O9 = O9();
        if (O9 != null && (U1 = O9.U1()) != null) {
            LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
            final Function1<xa.c, Unit> function12 = new Function1<xa.c, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxAlbumDetailSharePart$onInitData$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(xa.c cVar) {
                    invoke2(cVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(xa.c it) {
                    QZAlbumxAlbumDetailSharePart.this.P9();
                    if (it.getCooperation.qzone.QzoneIPCModule.RESULT_CODE java.lang.String() == 0) {
                        QZAlbumxAlbumDetailSharePart qZAlbumxAlbumDetailSharePart = QZAlbumxAlbumDetailSharePart.this;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        qZAlbumxAlbumDetailSharePart.U9(it);
                    }
                }
            };
            U1.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.ap
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZAlbumxAlbumDetailSharePart.S9(Function1.this, obj);
                }
            });
        }
        this.mShareManager.j(O9());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void T9() {
        MutableLiveData<CommonAlbumInfo> M1;
        CommonAlbumInfo value;
        nc.u O9;
        nc.y M9 = M9();
        if (M9 == null || (M1 = M9.M1()) == null || (value = M1.getValue()) == null || (O9 = O9()) == null) {
            return;
        }
        O9.W1(value.getAlbumId(), value.getCreator());
    }

    private final void V9() {
        Dialog dialog;
        boolean z16 = false;
        if (this.loadingDialog == null) {
            this.loadingDialog = LoadingUtil.showLoadingDialog(getActivity(), "\u52a0\u8f7d\u4e2d", false);
        }
        Dialog dialog2 = this.loadingDialog;
        if (dialog2 != null && dialog2.isShowing()) {
            z16 = true;
        }
        if (z16 || (dialog = this.loadingDialog) == null) {
            return;
        }
        dialog.show();
    }

    private final void W9(String tips) {
        DialogUtil.createCustomDialog(getActivity(), 230, com.tencent.biz.qqcircle.utils.h.a(R.string.fwj), tips, com.tencent.biz.qqcircle.utils.h.a(R.string.fox), com.tencent.biz.qqcircle.utils.h.a(R.string.fwi), new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.aq
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QZAlbumxAlbumDetailSharePart.X9(QZAlbumxAlbumDetailSharePart.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.ar
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QZAlbumxAlbumDetailSharePart.Y9(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(QZAlbumxAlbumDetailSharePart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J9();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    public final void L9() {
        MutableLiveData<xa.c> U1;
        xa.c value;
        nc.u O9 = O9();
        if (O9 == null || (U1 = O9.U1()) == null || (value = U1.getValue()) == null || value.getCooperation.qzone.QzoneIPCModule.RESULT_CODE java.lang.String() != 0) {
            return;
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        this.mShareManager.b(new ic.b(activity, this.mShareManager, value));
    }

    public final ShareActionSheet N9() {
        Object value = this.mSASBuilder.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mSASBuilder>(...)");
        return (ShareActionSheet) value;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0014, code lost:
    
        if (r0.isShowing() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void U9(xa.c rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        ShareActionSheet shareActionSheet = this.mShareManager.getShareActionSheet();
        boolean z16 = shareActionSheet != null;
        if (z16) {
            return;
        }
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = new ArrayList<>();
        N9().setActionSheetTitle(com.tencent.biz.qqcircle.utils.h.a(R.string.f134047r));
        this.mShareManager.i(N9());
        N9().setRowVisibility(0, 0, 0);
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        ic.b bVar = new ic.b(activity, this.mShareManager, rsp);
        for (Map.Entry<Integer, com.qzone.reborn.albumx.common.share.a<ic.b>> entry : this.mShareManager.e().entrySet()) {
            if (entry.getValue().b() == QQShareActionManager.ShareLine.FIRST) {
                I9(bVar, entry.getKey().intValue(), arrayList);
            } else if (entry.getValue().b() == QQShareActionManager.ShareLine.SECOND) {
                I9(bVar, entry.getKey().intValue(), arrayList2);
            }
        }
        Intent intent = new Intent();
        intent.putExtra("forward_type", 39);
        N9().setIntentForStartForwardRecentActivity(intent);
        this.mShareManager.h(arrayList, arrayList2);
        N9().setItemClickListenerV3(this);
        this.mShareManager.l(bVar);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.mShareManager.f(requestCode, resultCode, data);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        if (getActivity().getIntent() != null) {
            getActivity().getIntent().putExtra("big_brother_source_key", "biz_src_jc_qzone");
        }
        Q9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        P9();
        L9();
        this.mShareManager.g();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
    public void w6(View view, ShareActionSheetBuilder.ActionSheetItem item, ShareActionSheet shareActionSheet) {
        MutableLiveData<xa.c> U1;
        nc.u O9 = O9();
        xa.c value = (O9 == null || (U1 = O9.U1()) == null) ? null : U1.getValue();
        if (view == null || item == null || shareActionSheet == null || value == null || value.getCooperation.qzone.QzoneIPCModule.RESULT_CODE java.lang.String() != 0) {
            return;
        }
        com.qzone.reborn.albumx.common.share.a<ic.b> c16 = this.mShareManager.c(item.action);
        if (c16 != null) {
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            c16.a(new ic.b(activity, this.mShareManager, value), item);
        }
        L9();
    }
}
