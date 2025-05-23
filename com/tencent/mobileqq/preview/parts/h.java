package com.tencent.mobileqq.preview.parts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.api.IRichMediaDepend;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import com.tencent.richframework.gallery.widget.RFWGalleryViewPager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0002J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/preview/parts/h;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager$OnItemLongClickListener;", "", "B9", "Landroid/content/Context;", "context", "", "I9", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "H9", "G9", "", "D9", "C9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "position", "onItemLongClick", "onItemLongClickCancel", "onItemLongClickUp", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager;", "d", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager;", "mViewPagerRoot", "<init>", "()V", "e", "a", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class h extends RFWLayerBasePart implements RFWGalleryViewPager.OnItemLongClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RFWGalleryViewPager mViewPagerRoot;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/preview/parts/h$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.preview.parts.h$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22572);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String B9() {
        RFWLayerVideoInfo rFWLayerVideoInfo;
        RFWLayerPicInfo rFWLayerPicInfo;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo;
        RFWLayerPicInfo layerPicInfo;
        RFWLayerPicInfo.RFWPicInfo bigPicInfo;
        RFWLayerVideoInfo layerVideoInfo;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo2 = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo2 != null) {
            rFWLayerVideoInfo = rFWLayerItemMediaInfo2.getLayerVideoInfo();
        } else {
            rFWLayerVideoInfo = null;
        }
        if (rFWLayerVideoInfo != null) {
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo3 = this.mCurrentSelectedItem;
            if (rFWLayerItemMediaInfo3 == null || (layerVideoInfo = rFWLayerItemMediaInfo3.getLayerVideoInfo()) == null) {
                return null;
            }
            return layerVideoInfo.getLocalPath();
        }
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo4 = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo4 != null) {
            rFWLayerPicInfo = rFWLayerItemMediaInfo4.getLayerPicInfo();
        } else {
            rFWLayerPicInfo = null;
        }
        if (rFWLayerPicInfo == null || (rFWLayerItemMediaInfo = this.mCurrentSelectedItem) == null || (layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo()) == null || (bigPicInfo = layerPicInfo.getBigPicInfo()) == null) {
            return null;
        }
        return bigPicInfo.getLocalPath();
    }

    private final List<ShareActionSheetBuilder.ActionSheetItem> C9() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
        return arrayList;
    }

    private final List<ShareActionSheetBuilder.ActionSheetItem> D9() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(h this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        this$0.I9(activity);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(h this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IRichMediaDepend iRichMediaDepend = (IRichMediaDepend) QRoute.api(IRichMediaDepend.class);
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this$0.mCurrentSelectedItem;
        Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
        iRichMediaDepend.saveToAlbum(activity, rFWLayerItemMediaInfo);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void G9() {
        ArrayList arrayListOf;
        String B9 = B9();
        if (B9 != null) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(ah.k1(new FileInfo(B9)));
            ah.O(arrayListOf, getActivity());
        }
    }

    private final void H9(ShareActionSheetBuilder.ActionSheetItem item) {
        String B9 = B9();
        if (B9 == null) {
            return;
        }
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).forwardFileDirect(getActivity(), ah.k1(new FileInfo(B9)), item.uin, item.uinType);
    }

    private final void I9(Context context) {
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = context;
        getActivity().getIntent().putExtra("big_brother_source_key", "biz_src_unknown");
        ShareActionSheet create = ShareActionSheetFactory.create(param);
        Intrinsics.checkNotNullExpressionValue(create, "create(param)");
        create.setRowVisibility(0, 0, 0);
        create.setIntentForStartForwardRecentActivity(new Intent());
        create.setActionSheetItems(D9(), C9());
        create.setItemClickListenerV2(new ShareActionSheet.OnItemClickListener() { // from class: com.tencent.mobileqq.preview.parts.e
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
            public final void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                h.J9(h.this, actionSheetItem, shareActionSheet);
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(h this$0, ShareActionSheetBuilder.ActionSheetItem item, ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        shareActionSheet.dismiss();
        QLog.i("TBSToolMediaPreviewLayerSharePart", 1, "click action=" + item.action);
        int i3 = item.action;
        if (i3 != 2) {
            if (i3 != 39) {
                if (i3 == 72) {
                    Intrinsics.checkNotNullExpressionValue(item, "item");
                    this$0.H9(item);
                    return;
                }
                return;
            }
            IRichMediaDepend iRichMediaDepend = (IRichMediaDepend) QRoute.api(IRichMediaDepend.class);
            Activity activity = this$0.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this$0.mCurrentSelectedItem;
            Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
            iRichMediaDepend.saveToAlbum(activity, rFWLayerItemMediaInfo);
            return;
        }
        this$0.G9();
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
        ImageButton imageButton = (ImageButton) rootView.findViewById(R.id.zvd);
        imageButton.setVisibility(0);
        imageButton.setClickable(true);
        imageButton.setFocusable(true);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.preview.parts.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.E9(h.this, view);
            }
        });
        ImageButton imageButton2 = (ImageButton) rootView.findViewById(R.id.zvg);
        imageButton2.setVisibility(0);
        imageButton2.setClickable(true);
        imageButton2.setFocusable(true);
        imageButton2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.preview.parts.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.F9(h.this, view);
            }
        });
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
            QLog.e("TBSToolMediaPreviewLayerSharePart", 1, "activity is null return.");
            return;
        }
        if (this.mCurrentSelectedItem == null) {
            QLog.e("TBSToolMediaPreviewLayerSharePart", 1, "mCurrentSelectedItem is null. error!");
            return;
        }
        String B9 = B9();
        if (B9 == null) {
            return;
        }
        if (B9.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e("TBSToolMediaPreviewLayerSharePart", 1, "pic file Path error!");
        } else {
            if (!new File(B9).exists()) {
                QLog.e("TBSToolMediaPreviewLayerSharePart", 1, "pic file not exists. error!");
                return;
            }
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            I9(activity);
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
