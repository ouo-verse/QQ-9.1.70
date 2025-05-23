package com.tencent.robot.share.layer;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import com.tencent.richframework.gallery.widget.RFWGalleryViewPager;
import com.tencent.robot.share.layer.RobotLayerShareActionManager;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 92\u00020\u00012\u00020\u00022\u00020\u0003:\u0001:B\u000f\u0012\u0006\u0010(\u001a\u00020%\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J0\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u001c\u0010\u0018\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\"\u0010$\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u0007H\u0016R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001b\u00106\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105\u00a8\u0006;"}, d2 = {"Lcom/tencent/robot/share/layer/RobotLayerMorePart;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager$OnItemLongClickListener;", "", "D9", "E9", "Landroid/content/Intent;", "B9", "Lcom/tencent/robot/share/layer/f;", "shareContext", "", "action", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "Lkotlin/collections/ArrayList;", "list", "z9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "", "args", "handleBroadcastMessage", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "onItemClick", "position", "onItemLongClick", "onItemLongClickCancel", "onItemLongClickUp", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "onActivityResult", "Lcom/tencent/robot/share/layer/RobotLayerShareActionManager;", "d", "Lcom/tencent/robot/share/layer/RobotLayerShareActionManager;", "shareManager", "", "e", "Z", "isLoadPicSuccess", "Landroid/widget/ImageButton;", "f", "Landroid/widget/ImageButton;", "moreBtn", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2;", h.F, "Lkotlin/Lazy;", "A9", "()Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2;", "shareActionSheetBuilder", "<init>", "(Lcom/tencent/robot/share/layer/RobotLayerShareActionManager;)V", "i", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotLayerMorePart extends RFWLayerBasePart implements ShareActionSheet.OnItemClickListener, RFWGalleryViewPager.OnItemLongClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotLayerShareActionManager shareManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isLoadPicSuccess;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageButton moreBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy shareActionSheetBuilder;

    public RobotLayerMorePart(@NotNull RobotLayerShareActionManager shareManager) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(shareManager, "shareManager");
        this.shareManager = shareManager;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ShareActionSheetV2>() { // from class: com.tencent.robot.share.layer.RobotLayerMorePart$shareActionSheetBuilder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ShareActionSheetV2 invoke() {
                ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
                param.context = RobotLayerMorePart.this.getActivity();
                return new ShareActionSheetV2(param);
            }
        });
        this.shareActionSheetBuilder = lazy;
    }

    private final ShareActionSheetV2 A9() {
        return (ShareActionSheetV2) this.shareActionSheetBuilder.getValue();
    }

    private final Intent B9() {
        Intent intent = new Intent();
        intent.putExtra("forward_type", 0);
        intent.putExtra("forward _key_nojump", true);
        intent.putExtra("not_forward", true);
        ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
        forwardFileInfo.N(10000);
        forwardFileInfo.C(g.f368413a.a(this.mCurrentSelectedItem));
        intent.putExtra("fileinfo", forwardFileInfo);
        intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, forwardFileInfo.l());
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(RobotLayerMorePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void D9() {
        if (FastClickUtils.isFastDoubleClick("RobotLayerMorePart")) {
            return;
        }
        E9();
    }

    private final void E9() {
        if (!this.isLoadPicSuccess) {
            QLog.i("RobotLayerMorePart", 1, "isLoadPicSuccess false");
            return;
        }
        this.shareManager.e(A9());
        A9().setRowVisibility(0, 0, 0);
        if (getActivity().getIntent() != null) {
            getActivity().getIntent().putExtra("big_brother_source_key", "biz_src_jc_photo");
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        Object partHost = getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        RobotLayerShareActionManager robotLayerShareActionManager = this.shareManager;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
        RobotLayerShareContext robotLayerShareContext = new RobotLayerShareContext(activity, (Fragment) partHost, robotLayerShareActionManager, rFWLayerItemMediaInfo);
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = new ArrayList<>();
        for (Map.Entry<Integer, i54.a> entry : this.shareManager.c().entrySet()) {
            if (entry.getValue().a() == RobotLayerShareActionManager.ShareLine.FIRST) {
                z9(robotLayerShareContext, entry.getKey().intValue(), arrayList);
            } else if (entry.getValue().a() == RobotLayerShareActionManager.ShareLine.SECOND) {
                z9(robotLayerShareContext, entry.getKey().intValue(), arrayList2);
            }
        }
        this.shareManager.d(arrayList, arrayList2);
        A9().setItemClickListenerV2(this);
        A9().setIntentForStartForwardRecentActivity(B9());
        this.shareManager.f();
    }

    private final void z9(RobotLayerShareContext shareContext, int action, ArrayList<ShareActionSheetBuilder.ActionSheetItem> list) {
        i54.a b16 = this.shareManager.b(action);
        if (b16 != null && b16.d(shareContext)) {
            ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(action);
            build.visibility = 0;
            list.add(build);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        Boolean bool;
        boolean z16;
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "robot_layer_pic_load_finish")) {
            if (args instanceof Boolean) {
                bool = (Boolean) args;
            } else {
                bool = null;
            }
            if (bool != null) {
                z16 = bool.booleanValue();
            } else {
                z16 = false;
            }
            this.isLoadPicSuccess = z16;
            return;
        }
        if (Intrinsics.areEqual(action, "robot_layer_root_long_click")) {
            E9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 19005 && A9().isShowing()) {
            A9().dismiss();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ImageButton imageButton = (ImageButton) rootView.findViewById(R.id.f166866ir0);
        imageButton.setVisibility(0);
        imageButton.setClickable(true);
        imageButton.setFocusable(true);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.share.layer.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RobotLayerMorePart.C9(RobotLayerMorePart.this, view);
            }
        });
        this.moreBtn = imageButton;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
    public void onItemClick(@NotNull ShareActionSheetBuilder.ActionSheetItem item, @NotNull ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
        int i3 = item.action;
        if (i3 != 72) {
            A9().dismiss();
        }
        i54.a b16 = this.shareManager.b(i3);
        if (b16 != null) {
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            Object partHost = getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            RobotLayerShareActionManager robotLayerShareActionManager = this.shareManager;
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
            Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
            b16.b(new RobotLayerShareContext(activity, (Fragment) partHost, robotLayerShareActionManager, rFWLayerItemMediaInfo), item);
        }
    }

    @Override // com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClick(int position) {
        E9();
    }

    @Override // com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClickCancel(int position) {
    }

    @Override // com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClickUp(int position) {
    }
}
