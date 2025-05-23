package com.tencent.mobileqq.wink.picker.core.part;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.part.aj;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import e93.QZoneAlbumInfo;
import e93.QZoneAlbumStruct;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00132\u00020\u0001:\u0003\u0014\u0015\u0016B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/part/aj;", "Lcom/tencent/biz/richframework/part/Part;", "", "z9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/v;", "d", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/v;", "winkQZoneMediaViewModel", "Lcom/tencent/mobileqq/wink/picker/core/part/aj$a;", "e", "Lcom/tencent/mobileqq/wink/picker/core/part/aj$a;", "albumHorListAdapter", "<init>", "()V", "f", "a", "b", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class aj extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.picker.core.viewmodel.v winkQZoneMediaViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private a albumHorListAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/part/aj$a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/picker/core/part/aj$b;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "", "j0", "getItemCount", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/v;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/v;", "qZoneMediaViewModel", "", "Le93/k;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "i0", "()Ljava/util/List;", "albums", "<init>", "(Lcom/tencent/mobileqq/wink/picker/core/viewmodel/v;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends RecyclerView.Adapter<b> {

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private final List<QZoneAlbumStruct> albums = new ArrayList();

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final com.tencent.mobileqq.wink.picker.core.viewmodel.v qZoneMediaViewModel;

        public a(@Nullable com.tencent.mobileqq.wink.picker.core.viewmodel.v vVar) {
            this.qZoneMediaViewModel = vVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.albums.size();
        }

        @NotNull
        public final List<QZoneAlbumStruct> i0() {
            return this.albums;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull b holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.o(this.albums.get(position));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f169196i72, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026list_item, parent, false)");
            return new b(inflate, this.qZoneMediaViewModel);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0017\u001a\u00020\u000f\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\n \u000b*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\n \u000b*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/part/aj$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Le93/k;", "album", "", "o", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/v;", "E", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/v;", "qZoneMediaViewModel", "Lcom/tencent/mobileqq/widget/SquareImageView;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/widget/SquareImageView;", "albumCoverImg", "Landroid/view/View;", "G", "Landroid/view/View;", "albumCheckView", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "albumNameText", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/wink/picker/core/viewmodel/v;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private final com.tencent.mobileqq.wink.picker.core.viewmodel.v qZoneMediaViewModel;

        /* renamed from: F, reason: from kotlin metadata */
        private final SquareImageView albumCoverImg;

        /* renamed from: G, reason: from kotlin metadata */
        private final View albumCheckView;

        /* renamed from: H, reason: from kotlin metadata */
        private final TextView albumNameText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView, @Nullable com.tencent.mobileqq.wink.picker.core.viewmodel.v vVar) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.qZoneMediaViewModel = vVar;
            this.albumCoverImg = (SquareImageView) itemView.findViewById(R.id.ske);
            this.albumCheckView = itemView.findViewById(R.id.skd);
            this.albumNameText = (TextView) itemView.findViewById(R.id.skf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(QZoneAlbumStruct album, LoadState loadState, Option option) {
            Intrinsics.checkNotNullParameter(album, "$album");
            if (loadState == LoadState.STATE_DOWNLOAD_FAILED) {
                w53.b.f("WinkQZoneAlbumListPart", "load cover thumbUrl failed, try backup url");
                option.setUrl(album.getCoverUrlBackup());
                QQPicLoader qQPicLoader = QQPicLoader.f201806a;
                Intrinsics.checkNotNullExpressionValue(option, "option");
                qQPicLoader.e(option, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.wink.picker.core.part.am
                    @Override // com.tencent.libra.listener.IPicLoadStateListener
                    public final void onStateChange(LoadState loadState2, Option option2) {
                        aj.b.q(loadState2, option2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(LoadState loadState, Option option) {
            w53.b.f("WinkQZoneAlbumListPart", "load cover backup thumbUrl failed");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r(b this$0, QZoneAlbumStruct album, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(album, "$album");
            com.tencent.mobileqq.wink.picker.core.viewmodel.v vVar = this$0.qZoneMediaViewModel;
            if (vVar != null) {
                vVar.switchAlbum(album.getAlbumId());
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void o(@NotNull final QZoneAlbumStruct album) {
            Intrinsics.checkNotNullParameter(album, "album");
            LocalMediaInfo localMediaInfo = new LocalMediaInfo();
            e93.i.T(localMediaInfo, album.getCoverUrl());
            QQPicLoader qQPicLoader = QQPicLoader.f201806a;
            Option targetView = Option.obtain().setUrl(e93.i.w(localMediaInfo)).setTargetView(this.albumCoverImg);
            Intrinsics.checkNotNullExpressionValue(targetView, "obtain()\n               \u2026TargetView(albumCoverImg)");
            qQPicLoader.e(targetView, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.wink.picker.core.part.ak
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    aj.b.p(QZoneAlbumStruct.this, loadState, option);
                }
            });
            if (album.getIsChecked()) {
                this.albumCheckView.setBackgroundColor(this.itemView.getContext().getColor(R.color.qui_common_text_primary));
            } else {
                this.albumCheckView.setBackgroundColor(this.itemView.getContext().getColor(R.color.qui_common_text_secondary));
            }
            this.albumNameText.setText(album.getAlbumName());
            if (album.getIsChecked()) {
                this.itemView.setAlpha(1.0f);
            } else {
                this.itemView.setAlpha(0.5f);
            }
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.part.al
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    aj.b.r(aj.b.this, album, view);
                }
            });
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            String v3 = e93.i.v(localMediaInfo);
            if (v3 == null) {
                v3 = "";
            }
            com.tencent.mobileqq.wink.picker.report.a.t(itemView, v3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A9(aj this$0, QZoneAlbumInfo qZoneAlbumInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<QZoneAlbumStruct> a16 = qZoneAlbumInfo.a();
        a aVar = this$0.albumHorListAdapter;
        a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumHorListAdapter");
            aVar = null;
        }
        aVar.i0().clear();
        a aVar3 = this$0.albumHorListAdapter;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumHorListAdapter");
            aVar3 = null;
        }
        aVar3.i0().addAll(a16);
        a aVar4 = this$0.albumHorListAdapter;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumHorListAdapter");
        } else {
            aVar2 = aVar4;
        }
        aVar2.notifyDataSetChanged();
    }

    private final void z9() {
        LiveData<QZoneAlbumInfo> Q1;
        RecyclerView recyclerView = (RecyclerView) getPartRootView().findViewById(R.id.skg);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        recyclerView.addItemDecoration(new com.tencent.mobileqq.wink.view.f(com.tencent.mobileqq.wink.utils.i.a(getContext(), 8.0f)));
        a aVar = new a(this.winkQZoneMediaViewModel);
        this.albumHorListAdapter = aVar;
        recyclerView.setAdapter(aVar);
        com.tencent.mobileqq.wink.picker.core.viewmodel.v vVar = this.winkQZoneMediaViewModel;
        if (vVar != null && (Q1 = vVar.Q1()) != null) {
            Q1.observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.part.ai
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    aj.A9(aj.this, (QZoneAlbumInfo) obj);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkQZoneAlbumListPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        WinkMediaPickerMainBaseFragment<?> b16 = com.tencent.mobileqq.wink.picker.core.ktx.a.b(this);
        if (b16 != null) {
            this.winkQZoneMediaViewModel = com.tencent.mobileqq.wink.picker.core.viewmodel.q.i(b16);
        }
        z9();
    }
}
