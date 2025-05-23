package com.qzone.reborn.albumx.qzonex.part.albummember;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumMemberInitBean;
import com.qzone.reborn.base.k;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
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
import nc.ah;
import nc.ao;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050$\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0004\u001a\u00020\u0003H\u0002J0\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0006\u0010\u0018\u001a\u00020\u0003J\u0006\u0010\u0019\u001a\u00020\u0003J&\u0010\u001e\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\"\u0010#\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001b\u00102\u001a\u00020\u001c8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/albummember/QZAlbumxAlbumMemberInvitePart;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$c;", "", "I9", "Lic/a;", "shareContext", "", "action", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "Lkotlin/collections/ArrayList;", "list", "D9", "Lnc/ao;", "F9", "Lnc/ah;", "G9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "E9", "K9", "view", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "w6", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;", "d", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;", "getMShareManager", "()Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;", "mShareManager", "", "e", "Ljava/lang/String;", "TAG", "f", "Lkotlin/Lazy;", "H9", "()Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "mSASBuilder", "<init>", "(Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxAlbumMemberInvitePart extends k implements ShareActionSheet.c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QQShareActionManager<ic.a> mShareManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String TAG;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy mSASBuilder;

    public QZAlbumxAlbumMemberInvitePart(QQShareActionManager<ic.a> mShareManager) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mShareManager, "mShareManager");
        this.mShareManager = mShareManager;
        this.TAG = "QZAlbumxAlbumMemberInvitePart";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ShareActionSheet>() { // from class: com.qzone.reborn.albumx.qzonex.part.albummember.QZAlbumxAlbumMemberInvitePart$mSASBuilder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ShareActionSheet invoke() {
                ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
                param.context = QZAlbumxAlbumMemberInvitePart.this.getActivity();
                return ShareActionSheetFactory.create(param);
            }
        });
        this.mSASBuilder = lazy;
    }

    private final void D9(ic.a shareContext, int action, ArrayList<ShareActionSheetBuilder.ActionSheetItem> list) {
        com.qzone.reborn.albumx.common.share.a<ic.a> c16 = this.mShareManager.c(action);
        if (c16 != null && c16.f(shareContext)) {
            ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(action);
            build.visibility = c16.e() ? 0 : 8;
            list.add(build);
        }
    }

    private final ao F9() {
        return (ao) getViewModel(ao.class);
    }

    private final ah G9() {
        return (ah) getViewModel(ah.class);
    }

    private final void I9() {
        String str;
        QZAlbumxAlbumMemberInitBean initBean;
        String creatorUin;
        QZAlbumxAlbumMemberInitBean initBean2;
        MutableLiveData<Boolean> O1;
        ah G9 = G9();
        if (G9 != null && (O1 = G9.O1()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.albummember.QZAlbumxAlbumMemberInvitePart$onInitData$1
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
                        QZAlbumxAlbumMemberInvitePart.this.K9();
                    } else {
                        QZAlbumxAlbumMemberInvitePart.this.E9();
                    }
                }
            };
            O1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albummember.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZAlbumxAlbumMemberInvitePart.J9(Function1.this, obj);
                }
            });
        }
        ao F9 = F9();
        String str2 = "";
        if (F9 == null || (initBean2 = F9.getInitBean()) == null || (str = initBean2.getAlbumId()) == null) {
            str = "";
        }
        ao F92 = F9();
        if (F92 != null && (initBean = F92.getInitBean()) != null && (creatorUin = initBean.getCreatorUin()) != null) {
            str2 = creatorUin;
        }
        ah G92 = G9();
        if (G92 != null) {
            G92.Q1(str, str2);
        }
        this.mShareManager.j(G9());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void E9() {
        QZAlbumxAlbumMemberInitBean initBean;
        String albumId;
        ao F9;
        QZAlbumxAlbumMemberInitBean initBean2;
        String shareAlbumOwnerUin;
        ao F92;
        QZAlbumxAlbumMemberInitBean initBean3;
        String creatorUin;
        ao F93 = F9();
        if (F93 == null || (initBean = F93.getInitBean()) == null || (albumId = initBean.getAlbumId()) == null || (F9 = F9()) == null || (initBean2 = F9.getInitBean()) == null || (shareAlbumOwnerUin = initBean2.getShareAlbumOwnerUin()) == null || (F92 = F9()) == null || (initBean3 = F92.getInitBean()) == null || (creatorUin = initBean3.getCreatorUin()) == null) {
            return;
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        QQShareActionManager<ic.a> qQShareActionManager = this.mShareManager;
        CommonAlbumInfo commonAlbumInfo = new CommonAlbumInfo();
        commonAlbumInfo.V(albumId);
        commonAlbumInfo.getCreator().g(creatorUin);
        commonAlbumInfo.getShareAlbum().getOwner().g(shareAlbumOwnerUin);
        Unit unit = Unit.INSTANCE;
        this.mShareManager.b(new ic.a(activity, qQShareActionManager, commonAlbumInfo));
    }

    public final ShareActionSheet H9() {
        Object value = this.mSASBuilder.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mSASBuilder>(...)");
        return (ShareActionSheet) value;
    }

    public final void K9() {
        QZAlbumxAlbumMemberInitBean initBean;
        String albumId;
        ao F9;
        QZAlbumxAlbumMemberInitBean initBean2;
        String shareAlbumOwnerUin;
        ao F92;
        QZAlbumxAlbumMemberInitBean initBean3;
        String creatorUin;
        ao F93 = F9();
        if (F93 == null || (initBean = F93.getInitBean()) == null || (albumId = initBean.getAlbumId()) == null || (F9 = F9()) == null || (initBean2 = F9.getInitBean()) == null || (shareAlbumOwnerUin = initBean2.getShareAlbumOwnerUin()) == null || (F92 = F9()) == null || (initBean3 = F92.getInitBean()) == null || (creatorUin = initBean3.getCreatorUin()) == null) {
            return;
        }
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = new ArrayList<>();
        H9().setActionSheetTitle(h.a(R.string.f134037q));
        this.mShareManager.i(H9());
        H9().setRowVisibility(0, 0, 0);
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        QQShareActionManager<ic.a> qQShareActionManager = this.mShareManager;
        CommonAlbumInfo commonAlbumInfo = new CommonAlbumInfo();
        commonAlbumInfo.V(albumId);
        commonAlbumInfo.getCreator().g(creatorUin);
        commonAlbumInfo.getShareAlbum().getOwner().g(shareAlbumOwnerUin);
        Unit unit = Unit.INSTANCE;
        ic.a aVar = new ic.a(activity, qQShareActionManager, commonAlbumInfo);
        for (Map.Entry<Integer, com.qzone.reborn.albumx.common.share.a<ic.a>> entry : this.mShareManager.e().entrySet()) {
            if (entry.getValue().b() == QQShareActionManager.ShareLine.FIRST) {
                D9(aVar, entry.getKey().intValue(), arrayList);
            } else if (entry.getValue().b() == QQShareActionManager.ShareLine.SECOND) {
                D9(aVar, entry.getKey().intValue(), arrayList2);
            }
        }
        Intent intent = new Intent();
        intent.putExtra("forward_type", 39);
        H9().setIntentForStartForwardRecentActivity(intent);
        this.mShareManager.h(arrayList, arrayList2);
        H9().setItemClickListenerV3(this);
        this.mShareManager.l(aVar);
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
        I9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        E9();
        this.mShareManager.g();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
    public void w6(View view, ShareActionSheetBuilder.ActionSheetItem item, ShareActionSheet shareActionSheet) {
        QZAlbumxAlbumMemberInitBean initBean;
        QZAlbumxAlbumMemberInitBean initBean2;
        QZAlbumxAlbumMemberInitBean initBean3;
        ao F9 = F9();
        String str = null;
        String albumId = (F9 == null || (initBean3 = F9.getInitBean()) == null) ? null : initBean3.getAlbumId();
        ao F92 = F9();
        String shareAlbumOwnerUin = (F92 == null || (initBean2 = F92.getInitBean()) == null) ? null : initBean2.getShareAlbumOwnerUin();
        ao F93 = F9();
        if (F93 != null && (initBean = F93.getInitBean()) != null) {
            str = initBean.getCreatorUin();
        }
        if (view == null || item == null || shareActionSheet == null) {
            return;
        }
        if (albumId == null || albumId.length() == 0) {
            return;
        }
        if (shareAlbumOwnerUin == null || shareAlbumOwnerUin.length() == 0) {
            return;
        }
        if (str == null || str.length() == 0) {
            return;
        }
        com.qzone.reborn.albumx.common.share.a<ic.a> c16 = this.mShareManager.c(item.action);
        if (c16 != null) {
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            QQShareActionManager<ic.a> qQShareActionManager = this.mShareManager;
            CommonAlbumInfo commonAlbumInfo = new CommonAlbumInfo();
            commonAlbumInfo.V(albumId);
            commonAlbumInfo.getCreator().g(str);
            commonAlbumInfo.getShareAlbum().getOwner().g(shareAlbumOwnerUin);
            Unit unit = Unit.INSTANCE;
            c16.a(new ic.a(activity, qQShareActionManager, commonAlbumInfo), item);
        }
        E9();
    }
}
