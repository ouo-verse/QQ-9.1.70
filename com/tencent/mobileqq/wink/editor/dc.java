package com.tencent.mobileqq.wink.editor;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.event.ImagePageClickEvent;
import com.tencent.mobileqq.wink.event.ImagePageTouchEvent;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u0015\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0017J\b\u0010\f\u001a\u00020\u0005H\u0016R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/dc;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/editor/dc$b;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "n0", "holder", "position", "", "k0", "getItemCount", "", "Lcom/tencent/videocut/model/MediaModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "mediaModels", "<init>", "(Ljava/util/List;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class dc extends RecyclerView.Adapter<b> {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<MediaModel> mediaModels;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/dc$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", ParseCommon.CONTAINER, "<init>", "(Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View container) {
            super(container);
            Intrinsics.checkNotNullParameter(container, "container");
        }
    }

    public dc(@NotNull List<MediaModel> mediaModels) {
        Intrinsics.checkNotNullParameter(mediaModels, "mediaModels");
        this.mediaModels = mediaModels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ms.a.a("WinkImageAdapter", "[onBindViewHolder][onClick]");
        SimpleEventBus.getInstance().dispatchEvent(new ImagePageClickEvent());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m0(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            ms.a.a("WinkImageAdapter", "[onBindViewHolder][onTouch] down");
            SimpleEventBus.getInstance().dispatchEvent(new ImagePageTouchEvent());
            return false;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mediaModels.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position) {
        boolean z16;
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<MediaClip> list = this.mediaModels.get(position).videos;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            ms.a.i("WinkImageAdapter", "[onBindViewHolder] invalid videos");
            return;
        }
        View view = holder.itemView;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.da
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                dc.l0(view2);
            }
        });
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.wink.editor.db
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean m06;
                m06 = dc.m0(view2, motionEvent);
                return m06;
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.hdh, parent, false);
        Intrinsics.checkNotNullExpressionValue(root, "root");
        return new b(root);
    }
}
