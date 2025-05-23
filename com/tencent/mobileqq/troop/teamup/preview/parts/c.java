package com.tencent.mobileqq.troop.teamup.preview.parts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqforward.api.IForwardOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.robot.api.IRobotExtApi;
import com.tencent.richframework.gallery.api.IRichMediaDepend;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import com.tencent.richframework.gallery.widget.RFWGalleryViewPager;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0002J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0006\u0010\u0016\u001a\u00020\u0005R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/preview/parts/c;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager$OnItemLongClickListener;", "Landroid/content/Context;", "context", "", "E9", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "D9", "C9", "", "A9", "z9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "position", "onItemLongClick", "onItemLongClickCancel", "onItemLongClickUp", "B9", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager;", "d", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager;", "mViewPagerRoot", "<init>", "()V", "e", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c extends RFWLayerBasePart implements RFWGalleryViewPager.OnItemLongClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RFWGalleryViewPager mViewPagerRoot;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/preview/parts/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.teamup.preview.parts.c$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56027);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final List<ShareActionSheetBuilder.ActionSheetItem> A9() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        return arrayList;
    }

    private final void C9() {
        Bundle bundle = new Bundle();
        String a16 = com.tencent.mobileqq.troop.teamup.preview.utils.a.f299112a.a(this.mCurrentSelectedItem);
        bundle.putInt("forward_type", 1);
        bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, a16);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, a16);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, a16);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, a16);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        ((IForwardOption) QRoute.api(IForwardOption.class)).startForwardActivityForResult(getActivity(), intent, 21);
    }

    private final void D9(ShareActionSheetBuilder.ActionSheetItem item) {
        String a16 = com.tencent.mobileqq.troop.teamup.preview.utils.a.f299112a.a(this.mCurrentSelectedItem);
        File file = new File(a16);
        Bundle bundle = new Bundle(getActivity().getIntent().getExtras());
        bundle.putBoolean(AppConstants.Key.FORWARD_URLDRAWABLE, true);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL, new File(a16).toURI().toURL().toString());
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, new File(a16).toURI().toURL().toString());
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, file.getAbsolutePath());
        bundle.putInt("forward_type", 1);
        bundle.putInt(PeakConstants.SEND_SIZE_SPEC, 2);
        IRobotExtApi iRobotExtApi = (IRobotExtApi) QRoute.api(IRobotExtApi.class);
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        String str = item.uin;
        Intrinsics.checkNotNullExpressionValue(str, "item.uin");
        iRobotExtApi.shareRobotLocalPicToFriend(activity, bundle, str, item.uinType);
    }

    private final void E9(Context context) {
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = context;
        getActivity().getIntent().putExtra("big_brother_source_key", "biz_src_unknown");
        ShareActionSheet create = ShareActionSheetFactory.create(param);
        Intrinsics.checkNotNullExpressionValue(create, "create(param)");
        create.setRowVisibility(0, 0, 0);
        create.setIntentForStartForwardRecentActivity(new Intent());
        create.setActionSheetItems(A9(), z9());
        create.setItemClickListenerV2(new ShareActionSheet.OnItemClickListener() { // from class: com.tencent.mobileqq.troop.teamup.preview.parts.b
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
            public final void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                c.F9(c.this, actionSheetItem, shareActionSheet);
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(c this$0, ShareActionSheetBuilder.ActionSheetItem item, ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        shareActionSheet.dismiss();
        QLog.i("TroopPreviewLayerSharePart", 1, "click action=" + item.action);
        int i3 = item.action;
        if (i3 != 2) {
            if (i3 != 39) {
                if (i3 != 72) {
                    if (i3 != 73) {
                        return;
                    }
                } else {
                    Intrinsics.checkNotNullExpressionValue(item, "item");
                    this$0.D9(item);
                    return;
                }
            } else {
                this$0.B9();
                return;
            }
        }
        this$0.C9();
    }

    private final List<ShareActionSheetBuilder.ActionSheetItem> z9() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
        return arrayList;
    }

    public final void B9() {
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        String a16 = com.tencent.mobileqq.troop.teamup.preview.utils.a.f299112a.a(this.mCurrentSelectedItem);
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
        RFWLayerPicInfo layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo();
        if (layerPicInfo != null) {
            rFWPicInfo = layerPicInfo.getOriginPicInfo();
        } else {
            rFWPicInfo = null;
        }
        if (rFWPicInfo != null) {
            rFWPicInfo.setLocalPath(a16);
        }
        IRichMediaDepend iRichMediaDepend = (IRichMediaDepend) QRoute.api(IRichMediaDepend.class);
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo2 = this.mCurrentSelectedItem;
        Intrinsics.checkNotNull(rFWLayerItemMediaInfo2);
        iRichMediaDepend.saveToAlbum(activity, rFWLayerItemMediaInfo2);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        RFWGalleryViewPager rFWGalleryViewPager = (RFWGalleryViewPager) rootView.findViewById(R.id.f73943ux);
        rFWGalleryViewPager.setOnItemLongClickListener(this);
        this.mViewPagerRoot = rFWGalleryViewPager;
    }

    @Override // com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClick(int position) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, position);
            return;
        }
        if (getActivity() == null) {
            QLog.e("TroopPreviewLayerSharePart", 1, "activity is null return.");
            return;
        }
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo == null) {
            QLog.e("TroopPreviewLayerSharePart", 1, "mCurrentSelectedItem is null. error!");
            return;
        }
        String a16 = com.tencent.mobileqq.troop.teamup.preview.utils.a.f299112a.a(rFWLayerItemMediaInfo);
        if (a16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e("TroopPreviewLayerSharePart", 1, "pic file Path error!");
        } else {
            if (!new File(a16).exists()) {
                QLog.e("TroopPreviewLayerSharePart", 1, "pic file not exists. error!");
                return;
            }
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            E9(activity);
        }
    }

    @Override // com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClickCancel(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, position);
        }
    }

    @Override // com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClickUp(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, position);
        }
    }
}
