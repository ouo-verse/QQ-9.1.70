package com.tencent.mobileqq.markdown.multipic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.qqforward.api.IForwardOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qqnt.robot.api.IRobotExtApi;
import com.tencent.richframework.gallery.api.IRichMediaDepend;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import com.tencent.richframework.gallery.widget.RFWGalleryViewPager;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u001b\u0010\u0011\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/markdown/multipic/MultiPicMorePart;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager$OnItemLongClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "A9", "C9", "G9", "E9", "D9", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "F9", "onInitView", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "onItemClick", "", "position", "onItemLongClick", "onItemLongClickCancel", "onItemLongClickUp", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2;", "d", "Lkotlin/Lazy;", "z9", "()Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2;", "<init>", "()V", "e", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MultiPicMorePart extends RFWLayerBasePart implements ShareActionSheet.OnItemClickListener, RFWGalleryViewPager.OnItemLongClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy shareActionSheet;

    public MultiPicMorePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ShareActionSheetV2>() { // from class: com.tencent.mobileqq.markdown.multipic.MultiPicMorePart$shareActionSheet$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ShareActionSheetV2 invoke() {
                ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
                param.context = MultiPicMorePart.this.getActivity();
                return new ShareActionSheetV2(param);
            }
        });
        this.shareActionSheet = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(MultiPicMorePart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C9();
    }

    private final void C9() {
        if (FastClickUtils.isFastDoubleClick("MultiPicMorePart")) {
            return;
        }
        G9();
    }

    private final void D9() {
        String a16 = c.f243753a.a(this.mCurrentSelectedItem);
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, a16);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, a16);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, a16);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, a16);
        IRobotExtApi iRobotExtApi = (IRobotExtApi) QRoute.api(IRobotExtApi.class);
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        iRobotExtApi.shareRobotLocalPicToGuild(activity, bundle);
    }

    private final void E9() {
        String a16 = c.f243753a.a(this.mCurrentSelectedItem);
        Bundle bundle = new Bundle();
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

    private final void F9(ShareActionSheetBuilder.ActionSheetItem item) {
        File file = new File(c.f243753a.a(this.mCurrentSelectedItem));
        Bundle bundle = new Bundle(getActivity().getIntent().getExtras());
        bundle.putBoolean(AppConstants.Key.FORWARD_URLDRAWABLE, true);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL, file.toURI().toURL().toString());
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, file.toURI().toURL().toString());
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

    private final void G9() {
        z9().setRowVisibility(0, 0, 0);
        if (getActivity().getIntent() != null) {
            getActivity().getIntent().putExtra("big_brother_source_key", "biz_src_qqagent");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(171));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
        z9().setActionSheetItems(arrayList, arrayList2);
        z9().setItemClickListenerV2(this);
        ShareActionSheetV2 z95 = z9();
        Intent intent = new Intent();
        intent.putExtra("forward_type", 0);
        intent.putExtra("forward _key_nojump", true);
        intent.putExtra("not_forward", true);
        ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
        forwardFileInfo.N(10000);
        forwardFileInfo.C(c.f243753a.a(this.mCurrentSelectedItem));
        intent.putExtra("fileinfo", forwardFileInfo);
        intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, forwardFileInfo.l());
        z95.setIntentForStartForwardRecentActivity(intent);
        z9().show();
    }

    private final ShareActionSheetV2 z9() {
        return (ShareActionSheetV2) this.shareActionSheet.getValue();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        A9(rootView);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
    public void onItemClick(ShareActionSheetBuilder.ActionSheetItem item, ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
        int i3 = item.action;
        if (i3 == 2) {
            E9();
        } else if (i3 == 39) {
            IRichMediaDepend iRichMediaDepend = (IRichMediaDepend) QRoute.api(IRichMediaDepend.class);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
            Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
            iRichMediaDepend.saveToAlbum(context, rFWLayerItemMediaInfo);
        } else if (i3 == 72) {
            F9(item);
        } else if (i3 == 171) {
            D9();
        }
        shareActionSheet.dismiss();
    }

    @Override // com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClick(int position) {
        C9();
    }

    private final void A9(View rootView) {
        View findViewById = rootView.findViewById(R.id.f162728tr);
        findViewById.setClickable(true);
        findViewById.setFocusable(true);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.markdown.multipic.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MultiPicMorePart.B9(MultiPicMorePart.this, view);
            }
        });
        ((RFWGalleryViewPager) rootView.findViewById(R.id.f73943ux)).setOnItemLongClickListener(this);
    }

    @Override // com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClickCancel(int position) {
    }

    @Override // com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClickUp(int position) {
    }
}
