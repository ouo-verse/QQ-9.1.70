package com.tencent.state.square.holder;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.data.Gender;
import com.tencent.state.map.IMapPlayManager;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapItemController;
import com.tencent.state.map.MapPlayableViewHolder;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.IRouter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareRecommendUserItem;
import com.tencent.state.square.databinding.VasSquareItemRecommendUserBinding;
import com.tencent.state.square.mayknow.MayKnowLabel;
import com.tencent.state.square.resource.IResourceCallback;
import com.tencent.state.square.resource.RecordRequest;
import com.tencent.state.view.SquareMayKnowLabelView;
import com.tencent.state.view.SquareTabLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0014J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u0018H\u0014R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/state/square/holder/RecommendUserViewHolder;", "Lcom/tencent/state/map/MapPlayableViewHolder;", "Lcom/tencent/state/square/data/SquareRecommendUserItem;", "Lcom/tencent/state/square/resource/IResourceCallback;", "Landroid/view/View$OnClickListener;", "binding", "Lcom/tencent/state/square/databinding/VasSquareItemRecommendUserBinding;", "(Lcom/tencent/state/square/databinding/VasSquareItemRecommendUserBinding;)V", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareItemRecommendUserBinding;", "bindAvatar", "", "data", "bindLabels", "bindRecommendMessage", "doBind", "index", "", "getPlayerView", "Lcom/tencent/state/square/avatar/SquareAvatarView;", NodeProps.ON_CLICK, "v", "Landroid/view/View;", "onFirstScreenCompleted", "Lcom/tencent/state/map/MapItem;", "onRecordSuccess", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/state/square/resource/RecordRequest;", "resizeAvatar", "transform", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class RecommendUserViewHolder extends MapPlayableViewHolder<SquareRecommendUserItem> implements IResourceCallback, View.OnClickListener {
    private final VasSquareItemRecommendUserBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RecommendUserViewHolder(VasSquareItemRecommendUserBinding binding) {
        super(r0);
        Intrinsics.checkNotNullParameter(binding, "binding");
        LinearLayout mContainer = binding.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root");
        this.binding = binding;
    }

    private final void bindLabels(SquareRecommendUserItem data) {
        Integer valueOf;
        boolean isBlank;
        this.binding.recommendUserLabelsContainer.removeAllViews();
        Integer gender = data.getUser().getGender();
        int ordinal = Gender.MALE.ordinal();
        String str = null;
        if (gender != null && gender.intValue() == ordinal) {
            valueOf = Integer.valueOf(R.drawable.f159813ia2);
        } else {
            valueOf = (gender != null && gender.intValue() == Gender.FEMALE.ordinal()) ? Integer.valueOf(R.drawable.i9o) : null;
        }
        Integer age = data.getUser().getAge();
        if (age == null || age.intValue() != 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(data.getUser().getAge());
            sb5.append('\u5c81');
            str = sb5.toString();
        }
        if (valueOf != null && str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                SquareTabLayout squareTabLayout = this.binding.recommendUserLabelsContainer;
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                Context context = itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                SquareMayKnowLabelView squareMayKnowLabelView = new SquareMayKnowLabelView(context);
                squareMayKnowLabelView.updateView(str, valueOf, ViewExtensionsKt.dip(squareMayKnowLabelView.getContext(), 2));
                Unit unit = Unit.INSTANCE;
                squareTabLayout.addView(squareMayKnowLabelView);
            }
        }
        for (MayKnowLabel mayKnowLabel : data.getUser().getLabels()) {
            SquareTabLayout squareTabLayout2 = this.binding.recommendUserLabelsContainer;
            View itemView2 = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
            Context context2 = itemView2.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
            SquareMayKnowLabelView squareMayKnowLabelView2 = new SquareMayKnowLabelView(context2);
            String name = mayKnowLabel.getName();
            View itemView3 = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView3, "itemView");
            SquareMayKnowLabelView.updateView$default(squareMayKnowLabelView2, name, null, ViewExtensionsKt.dip(itemView3.getContext(), 2), 2, null);
            Unit unit2 = Unit.INSTANCE;
            squareTabLayout2.addView(squareMayKnowLabelView2);
        }
    }

    private final void bindRecommendMessage(SquareRecommendUserItem data) {
        TextView textView = this.binding.recommendUserName;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.recommendUserName");
        textView.setText(data.getName());
        TextView textView2 = this.binding.recommendReason;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.recommendReason");
        textView2.setText(data.getUser().getMayKnowReason());
        bindLabels(data);
    }

    public final VasSquareItemRecommendUserBinding getBinding() {
        return this.binding;
    }

    @Override // com.tencent.state.map.MapPlayableViewHolder
    public SquareAvatarView getPlayerView() {
        SquareAvatarView squareAvatarView = this.binding.recommendUserAvatar;
        Intrinsics.checkNotNullExpressionValue(squareAvatarView, "binding.recommendUserAvatar");
        return squareAvatarView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        Map<String, Object> mutableMapOf;
        SquareRecommendUserItem squareRecommendUserItem = (SquareRecommendUserItem) getData();
        if (squareRecommendUserItem != null) {
            Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
            SquareAvatarView squareAvatarView = this.binding.recommendUserAvatar;
            Intrinsics.checkNotNullExpressionValue(squareAvatarView, "binding.recommendUserAvatar");
            int id5 = squareAvatarView.getId();
            if (valueOf != null && valueOf.intValue() == id5) {
                String checkNearby = SquareReportConst.PageId.INSTANCE.checkNearby();
                IRouter router = Square.INSTANCE.getConfig().getRouter();
                Context context = v3.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "v.context");
                router.routeToFriendProfileCard(context, squareRecommendUserItem.getUin(), squareRecommendUserItem.getName(), squareRecommendUserItem.getUser().getMayKnowReason());
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                SquareAvatarView squareAvatarView2 = this.binding.recommendUserAvatar;
                Intrinsics.checkNotNullExpressionValue(squareAvatarView2, "binding.recommendUserAvatar");
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_AVATAR_RELATIONSHIP, 2), TuplesKt.to("dt_pgid", checkNearby), TuplesKt.to("pgid", checkNearby));
                squareReporter.reportEvent("clck", squareAvatarView2, mutableMapOf);
            }
        }
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onFirstFrame() {
        IResourceCallback.DefaultImpls.onFirstFrame(this);
    }

    @Override // com.tencent.state.map.MapViewHolder
    public void onFirstScreenCompleted(MapItem data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onPlayEnd() {
        IResourceCallback.DefaultImpls.onPlayEnd(this);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onPlayError(int i3) {
        IResourceCallback.DefaultImpls.onPlayError(this, i3);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onPlayStart() {
        IResourceCallback.DefaultImpls.onPlayStart(this);
    }

    @Override // com.tencent.state.square.resource.IResourceCallback
    public void onRecordError(int i3, RecordRequest request, int i16) {
        Intrinsics.checkNotNullParameter(request, "request");
        IResourceCallback.DefaultImpls.onRecordError(this, i3, request, i16);
    }

    @Override // com.tencent.state.square.resource.IResourceCallback
    public void onRecordStart(Resource resource, boolean z16) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        IResourceCallback.DefaultImpls.onRecordStart(this, resource, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.square.resource.IResourceCallback
    public void onRecordSuccess(RecordRequest request) {
        MapItemController controller;
        IMapPlayManager rpm;
        Resource userResource;
        Intrinsics.checkNotNullParameter(request, "request");
        SquareRecommendUserItem squareRecommendUserItem = (SquareRecommendUserItem) getData();
        Integer valueOf = (squareRecommendUserItem == null || (userResource = squareRecommendUserItem.getUserResource()) == null) ? null : Integer.valueOf(userResource.getActionId());
        Resource resource = request.getResource();
        if (!Intrinsics.areEqual(valueOf, resource != null ? Integer.valueOf(resource.getActionId()) : null) || (controller = getController()) == null || (rpm = controller.getRpm()) == null) {
            return;
        }
        rpm.pauseAndEnsurePlay(getIndex());
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onRemovedListener() {
        IResourceCallback.DefaultImpls.onRemovedListener(this);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onStaticFailed() {
        IResourceCallback.DefaultImpls.onStaticFailed(this);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onStaticSuccess() {
        IResourceCallback.DefaultImpls.onStaticSuccess(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapPlayableViewHolder
    public void bindAvatar(SquareRecommendUserItem data) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(data, "data");
        getRm().setAvatarResource(data, false, this);
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        SquareAvatarView squareAvatarView = this.binding.recommendUserAvatar;
        Intrinsics.checkNotNullExpressionValue(squareAvatarView, "binding.recommendUserAvatar");
        squareReporter.setElementInfo(squareAvatarView, SquareReportConst.ElementId.ELEMENT_ID_AVATAR_ICON, new LinkedHashMap(), false, false);
        String checkNearby = SquareReportConst.PageId.INSTANCE.checkNearby();
        IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
        SquareAvatarView squareAvatarView2 = this.binding.recommendUserAvatar;
        Intrinsics.checkNotNullExpressionValue(squareAvatarView2, "binding.recommendUserAvatar");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_AVATAR_RELATIONSHIP, 2), TuplesKt.to("dt_pgid", checkNearby), TuplesKt.to("pgid", checkNearby));
        squareReporter2.reportEvent("imp", squareAvatarView2, mutableMapOf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapViewHolder
    public void doBind(SquareRecommendUserItem data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
        resizeAvatar(data);
        bindAvatar(data);
        bindRecommendMessage(data);
        this.binding.recommendUserAvatar.setOnClickListener(this);
    }

    @Override // com.tencent.state.map.MapPlayableViewHolder
    public void resizeAvatar(SquareRecommendUserItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Location location = data.getLocation();
        resizeAvatar(location.getWidth(), location.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapViewHolder
    public SquareRecommendUserItem transform(MapItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof SquareRecommendUserItem)) {
            data = null;
        }
        return (SquareRecommendUserItem) data;
    }
}
