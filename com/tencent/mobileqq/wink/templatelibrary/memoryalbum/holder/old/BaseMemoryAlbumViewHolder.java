package com.tencent.mobileqq.wink.templatelibrary.memoryalbum.holder.old;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.view.RoundCornerImageView;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import e93.i;
import ja3.b;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0014J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/holder/old/BaseMemoryAlbumViewHolder;", "Lja3/b;", "Ls53/a;", "data", "", "position", "spanCount", "", "J", "O", "M", "N", "K", "Landroid/view/View;", "view", "P", "itemView", "Lia3/b;", "clickListener", "<init>", "(Landroid/view/View;Lia3/b;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class BaseMemoryAlbumViewHolder extends b<s53.a> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseMemoryAlbumViewHolder(@NotNull View itemView, @Nullable ia3.b bVar) {
        super(itemView, bVar);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(BaseMemoryAlbumViewHolder this$0, s53.a data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        ia3.b clickListener = this$0.getClickListener();
        if (clickListener != null) {
            clickListener.a(data);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void J(@Nullable s53.a data, int position, int spanCount) {
        super.m(data, position, spanCount);
        P(getImageView(), data);
    }

    @Override // ja3.b
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void n(@NotNull final s53.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        RoundCornerImageView imageView = getImageView();
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.holder.old.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseMemoryAlbumViewHolder.L(BaseMemoryAlbumViewHolder.this, data, view);
                }
            });
        }
    }

    @Override // ja3.b
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public void q(@NotNull s53.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        TextView date = getDate();
        if (date != null) {
            date.setText(pa3.a.f425848a.a(data.getTimestamp(), "yyyy\u5e74MM\u6708dd\u65e5"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ja3.b
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void s(@NotNull s53.a data, int spanCount) {
        LocalMediaInfo originPhoto;
        Intrinsics.checkNotNullParameter(data, "data");
        super.s(data, spanCount);
        s53.b coverPhoto = data.getCoverPhoto();
        if (coverPhoto != null && (originPhoto = coverPhoto.getOriginPhoto()) != null) {
            int screenWidth = ImmersiveUtils.getScreenWidth() / spanCount;
            b.p(this, originPhoto.path, getImageView(), screenWidth, (int) (screenWidth * 1.5f), null, i.I(originPhoto), false, 80, null);
        }
    }

    @Override // ja3.b
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void u(@NotNull s53.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        TextView name = getName();
        if (name != null) {
            name.setText(data.d().getStoryName());
        }
    }

    protected void P(@Nullable View view, @Nullable final s53.a data) {
        C(view, WinkDaTongReportConstant.ElementId.EM_XSJ_MEMORIES_ALBUM, data, new Function1<Map<String, Object>, Unit>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.holder.old.BaseMemoryAlbumViewHolder$itemDtReport$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, Object> map) {
                invoke2(map);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Map<String, Object> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                s53.a aVar = s53.a.this;
                it.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MEMORIES_ALBUM_ID, aVar != null ? aVar.getId() : null);
            }
        }, new Function1<s53.a, Unit>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.holder.old.BaseMemoryAlbumViewHolder$itemDtReport$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(s53.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable s53.a aVar) {
                s53.a aVar2 = s53.a.this;
                if (aVar2 == null) {
                    return;
                }
                aVar2.r(true);
            }
        });
    }
}
