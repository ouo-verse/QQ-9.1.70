package com.qzone.reborn.groupalbum.part.albumdetail;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumAlbumDetailInitBean;
import com.qzone.reborn.groupalbum.reship.util.GroupAlbumReshipUtil;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernel.nativeinterface.QunMediaRightEnum;
import com.tencent.util.ArrayUtils;
import cooperation.qzone.util.QZonePermission;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\u0018\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J \u0010\u0013\u001a\u00020\u00032\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH\u0002J*\u0010\u0016\u001a\u00020\u00032\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001cH\u0014J\b\u0010\u001f\u001a\u00020\u0010H\u0014J\b\u0010 \u001a\u00020\u0010H\u0014J\b\u0010!\u001a\u00020\u0010H\u0014J \u0010\"\u001a\u00020\u00032\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH\u0014J \u0010#\u001a\u00020\u00032\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH\u0014J \u0010$\u001a\u00020\u00032\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH\u0014R\u0014\u0010'\u001a\u00020\u00078\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u00078\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0014\u0010+\u001a\u00020\u00078\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b*\u0010&R$\u00102\u001a\u00020,2\u0006\u0010-\u001a\u00020,8\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/albumdetail/GroupAlbumAlbumDetailOperatePanelPart;", "Lcom/qzone/reborn/albumx/common/part/i;", "Landroid/view/View$OnClickListener;", "", "Da", "Landroid/view/View;", "view", "", "itemName", "Fa", "wa", "Ea", "Ljava/util/ArrayList;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "Lkotlin/collections/ArrayList;", "Ha", "", "Ia", "mediaList", "Aa", "Landroid/content/DialogInterface;", "dialog", "va", "Lcom/qzone/reborn/albumx/common/viewmodel/a;", "info", "Ja", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "selectCount", "na", "V9", "U9", "W9", "Q9", "P9", "S9", "J", "Ljava/lang/String;", "DOWNLOAD_FLAG", "K", "DELETE_FLAG", "L", "RESHIP_FLAG", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", "<set-?>", "M", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", "Ga", "()Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", "initBean", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class GroupAlbumAlbumDetailOperatePanelPart extends com.qzone.reborn.albumx.common.part.i {

    /* renamed from: J, reason: from kotlin metadata */
    private final String DOWNLOAD_FLAG = "1";

    /* renamed from: K, reason: from kotlin metadata */
    private final String DELETE_FLAG = "2";

    /* renamed from: L, reason: from kotlin metadata */
    private final String RESHIP_FLAG = "3";

    /* renamed from: M, reason: from kotlin metadata */
    private GroupAlbumAlbumDetailInitBean initBean;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/qzone/reborn/groupalbum/part/albumdetail/GroupAlbumAlbumDetailOperatePanelPart$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<CommonStMedia> f56628b;

        a(ArrayList<CommonStMedia> arrayList) {
            this.f56628b = arrayList;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            GroupAlbumAlbumDetailOperatePanelPart.this.L9().m2(GroupAlbumAlbumDetailOperatePanelPart.this.Ga().getGroupId(), "0", this.f56628b);
        }
    }

    private final void Aa(final ArrayList<CommonStMedia> mediaList) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, HardCodeUtil.qqStr(R.string.sxp), HardCodeUtil.qqStr(R.string.stc), HardCodeUtil.qqStr(R.string.sqw), HardCodeUtil.qqStr(R.string.srk), new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.groupalbum.part.albumdetail.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GroupAlbumAlbumDetailOperatePanelPart.Ba(GroupAlbumAlbumDetailOperatePanelPart.this, mediaList, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.groupalbum.part.albumdetail.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GroupAlbumAlbumDetailOperatePanelPart.Ca(dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026nt -> dialog1.dismiss() }");
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ba(GroupAlbumAlbumDetailOperatePanelPart this$0, ArrayList mediaList, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaList, "$mediaList");
        this$0.va(mediaList, dialogInterface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(DialogInterface dialog1, int i3) {
        Intrinsics.checkNotNullParameter(dialog1, "dialog1");
        dialog1.dismiss();
    }

    private final void Da() {
        if (V9()) {
            Fa(I9(), this.DOWNLOAD_FLAG);
        }
        if (U9()) {
            Fa(H9(), this.DELETE_FLAG);
        }
        if (W9()) {
            Fa(K9(), this.RESHIP_FLAG);
        }
    }

    private final void Ea() {
        if (F9().M1().getValue() == null) {
            return;
        }
        ci.j jVar = new ci.j();
        com.qzone.reborn.albumx.common.viewmodel.b F9 = F9();
        Intrinsics.checkNotNull(F9, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.viewmodel.GroupAlbumAlbumDetailViewModel");
        GroupAlbumAlbumDetailInitBean mInitBean = ((com.qzone.reborn.groupalbum.viewmodel.b) F9).getMInitBean();
        jVar.f(mInitBean != null ? mInitBean.getGroupId() : null);
        CommonAlbumInfo value = F9().M1().getValue();
        jVar.e(value != null ? value.getAlbumId() : null);
        jVar.g(Ha());
        jVar.h(0);
        com.qzone.reborn.albumx.common.viewmodel.b F92 = F9();
        Intrinsics.checkNotNull(F92, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.viewmodel.GroupAlbumAlbumDetailViewModel");
        jVar.j(((com.qzone.reborn.groupalbum.viewmodel.b) F92).getDataRepo());
        L9().T1(jVar);
        L9().Q1();
    }

    private final ArrayList<CommonStMedia> Ha() {
        if (Ia()) {
            return L9().W1();
        }
        ArrayList<CommonStMedia> arrayList = new ArrayList<>();
        for (CommonStMedia commonStMedia : L9().W1()) {
            ki.d dVar = ki.d.f412455a;
            String str = commonStMedia.getCom.tencent.weiyun.transmission.db.JobDbManager.TBL_UPLOAD java.lang.String();
            if (str == null) {
                str = "";
            }
            if (dVar.f(str)) {
                arrayList.add(commonStMedia);
            }
        }
        return arrayList;
    }

    private final boolean Ia() {
        com.qzone.reborn.albumx.common.viewmodel.b F9 = F9();
        Intrinsics.checkNotNull(F9, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.viewmodel.GroupAlbumAlbumDetailViewModel");
        ArrayList<Integer> value = ((com.qzone.reborn.groupalbum.viewmodel.b) F9).T1().getValue();
        return value != null && value.contains(Integer.valueOf(QunMediaRightEnum.KQUNMEDIARIGHTENUMDELETEALBUM.ordinal()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ja(com.qzone.reborn.albumx.common.viewmodel.a info) {
        if (info.c()) {
            QQToast.makeText(BaseApplication.getContext(), 5, R.string.slz, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ka(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void va(ArrayList<CommonStMedia> mediaList, DialogInterface dialog) {
        if (ki.d.f412455a.d(mediaList)) {
            if (dialog != null) {
                dialog.dismiss();
            }
            L9().d2().postValue(Boolean.FALSE);
            L9().b2().clear();
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.stc, 0).show();
            return;
        }
        wa();
    }

    private final void wa() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, HardCodeUtil.qqStr(R.string.ssh), "\u5220\u9664\u540e\u7fa4\u6210\u5458\u90fd\u5c06\u65e0\u6cd5\u67e5\u770b", HardCodeUtil.qqStr(R.string.sqw), HardCodeUtil.qqStr(R.string.srk), new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.groupalbum.part.albumdetail.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GroupAlbumAlbumDetailOperatePanelPart.xa(GroupAlbumAlbumDetailOperatePanelPart.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.groupalbum.part.albumdetail.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GroupAlbumAlbumDetailOperatePanelPart.za(dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026nt -> dialog1.dismiss() }");
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(GroupAlbumAlbumDetailOperatePanelPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ea();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(DialogInterface dialog1, int i3) {
        Intrinsics.checkNotNullParameter(dialog1, "dialog1");
        dialog1.dismiss();
    }

    public final GroupAlbumAlbumDetailInitBean Ga() {
        GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean = this.initBean;
        if (groupAlbumAlbumDetailInitBean != null) {
            return groupAlbumAlbumDetailInitBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initBean");
        return null;
    }

    @Override // com.qzone.reborn.albumx.common.part.i
    protected void P9(ArrayList<CommonStMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.to9, 0).show();
        } else if (!ki.d.f412455a.e(mediaList) && !Ia()) {
            Aa(mediaList);
        } else {
            wa();
        }
    }

    @Override // com.qzone.reborn.albumx.common.part.i
    protected void Q9(ArrayList<CommonStMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.to9, 0).show();
        } else if (QZonePermission.requestStoragePermission(getActivity(), new a(mediaList), QQPermissionConstants.Business.SCENE.QQ_QZONE_SAVE_MEDIA_TO_ALBUM)) {
            L9().m2(Ga().getGroupId(), "0", mediaList);
        }
    }

    @Override // com.qzone.reborn.albumx.common.part.i
    protected void S9(ArrayList<CommonStMedia> mediaList) {
        String str;
        String albumId;
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (mediaList.size() > 100) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.tag, 0).show();
            return;
        }
        com.qzone.reborn.albumx.common.viewmodel.b F9 = F9();
        Intrinsics.checkNotNull(F9, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.viewmodel.GroupAlbumAlbumDetailViewModel");
        GroupAlbumAlbumDetailInitBean mInitBean = ((com.qzone.reborn.groupalbum.viewmodel.b) F9).getMInitBean();
        String str2 = "";
        if (mInitBean == null || (str = mInitBean.getGroupId()) == null) {
            str = "";
        }
        CommonAlbumInfo value = F9().M1().getValue();
        if (value != null && (albumId = value.getAlbumId()) != null) {
            str2 = albumId;
        }
        GroupAlbumReshipUtil groupAlbumReshipUtil = GroupAlbumReshipUtil.f56889a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        groupAlbumReshipUtil.a(mediaList, str, str2, context);
    }

    @Override // com.qzone.reborn.albumx.common.part.i
    protected boolean U9() {
        return true;
    }

    @Override // com.qzone.reborn.albumx.common.part.i
    protected boolean V9() {
        return true;
    }

    @Override // com.qzone.reborn.albumx.common.part.i
    protected boolean W9() {
        return true;
    }

    @Override // com.qzone.reborn.albumx.common.part.i, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intent intent;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        Activity activity = getActivity();
        Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra("key_bundle_common_init_bean");
        GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean = serializableExtra instanceof GroupAlbumAlbumDetailInitBean ? (GroupAlbumAlbumDetailInitBean) serializableExtra : null;
        Intrinsics.checkNotNull(groupAlbumAlbumDetailInitBean);
        this.initBean = groupAlbumAlbumDetailInitBean;
        MutableLiveData<com.qzone.reborn.albumx.common.viewmodel.a> X1 = L9().X1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.qzone.reborn.albumx.common.viewmodel.a, Unit> function1 = new Function1<com.qzone.reborn.albumx.common.viewmodel.a, Unit>() { // from class: com.qzone.reborn.groupalbum.part.albumdetail.GroupAlbumAlbumDetailOperatePanelPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.qzone.reborn.albumx.common.viewmodel.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.qzone.reborn.albumx.common.viewmodel.a aVar) {
                if (aVar == null) {
                    return;
                }
                GroupAlbumAlbumDetailOperatePanelPart.this.Ja(aVar);
            }
        };
        X1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.groupalbum.part.albumdetail.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GroupAlbumAlbumDetailOperatePanelPart.Ka(Function1.this, obj);
            }
        });
        Da();
    }

    private final void Fa(View view, String itemName) {
        Map mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, itemName));
        fo.c.p("em_qz_batch_operation_panel", "pg_qz_group_album_details", view, mutableMapOf);
    }

    @Override // com.qzone.reborn.albumx.common.part.i
    protected void na(int selectCount) {
    }
}
