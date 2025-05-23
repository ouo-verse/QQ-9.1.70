package com.tencent.mobileqq.wink.templatelibrary.memoryalbum.holder.p009new;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp;
import com.tencent.mobileqq.wink.view.RoundCornerImageView;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import ja3.b;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z83.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0014J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u001c\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/holder/new/BaseNewAlbumViewHolder;", "Lja3/b;", "Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewMemoryAlbumResult;", "data", "", "position", "spanCount", "", "K", BdhLogUtil.LogTag.Tag_Req, "N", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "L", "O", "Landroid/view/View;", "view", "T", "itemView", "Lia3/b;", "clickListener", "<init>", "(Landroid/view/View;Lia3/b;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class BaseNewAlbumViewHolder extends b<WinkNewMemoryAlbumResult> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseNewAlbumViewHolder(@NotNull View itemView, @Nullable ia3.b bVar) {
        super(itemView, bVar);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(BaseNewAlbumViewHolder this$0, WinkNewMemoryAlbumResult data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        ia3.b clickListener = this$0.getClickListener();
        if (clickListener != null) {
            clickListener.c(data);
        }
        WinkNewAlbumDatabaseImp.k(data);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(BaseNewAlbumViewHolder this$0, WinkNewMemoryAlbumResult data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        ia3.b clickListener = this$0.getClickListener();
        if (clickListener != null) {
            clickListener.b(data);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void K(@Nullable WinkNewMemoryAlbumResult data, int position, int spanCount) {
        super.m(data, position, spanCount);
        T(getImageView(), data);
    }

    @Override // ja3.b
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public void n(@NotNull final WinkNewMemoryAlbumResult data) {
        Intrinsics.checkNotNullParameter(data, "data");
        RoundCornerImageView imageView = getImageView();
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.holder.new.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseNewAlbumViewHolder.M(BaseNewAlbumViewHolder.this, data, view);
                }
            });
        }
    }

    @Override // ja3.b
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void q(@NotNull WinkNewMemoryAlbumResult data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ja3.b
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void r(@NotNull final WinkNewMemoryAlbumResult data) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.r(data);
        Button debug = getDebug();
        if (debug != null) {
            debug.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.holder.new.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseNewAlbumViewHolder.P(BaseNewAlbumViewHolder.this, data, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ja3.b
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void s(@NotNull WinkNewMemoryAlbumResult data, int spanCount) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.s(data, spanCount);
        a b16 = data.b();
        if (b16 != null) {
            int screenWidth = ImmersiveUtils.getScreenWidth() / spanCount;
            b.p(this, b16.getPath(), getImageView(), screenWidth, (int) (screenWidth * 1.5f), null, b16.D(), false, 80, null);
        }
    }

    @Override // ja3.b
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public void u(@NotNull WinkNewMemoryAlbumResult data) {
        Intrinsics.checkNotNullParameter(data, "data");
        TextView name = getName();
        if (name != null) {
            name.setText(data.getCom.tencent.aelight.camera.constants.AEEditorConstants.ALBUMNAME java.lang.String());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void T(@Nullable View view, @Nullable final WinkNewMemoryAlbumResult data) {
        C(view, WinkDaTongReportConstant.ElementId.EM_XSJ_MEMORIES_ALBUM, data, new Function1<Map<String, Object>, Unit>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.holder.new.BaseNewAlbumViewHolder$itemDtReport$1
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
                WinkNewMemoryAlbumResult winkNewMemoryAlbumResult = WinkNewMemoryAlbumResult.this;
                String storyID = winkNewMemoryAlbumResult != null ? winkNewMemoryAlbumResult.getStoryID() : null;
                WinkNewMemoryAlbumResult winkNewMemoryAlbumResult2 = WinkNewMemoryAlbumResult.this;
                it.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MEMORIES_ALBUM_ID, storyID + (winkNewMemoryAlbumResult2 != null ? winkNewMemoryAlbumResult2.getAlbumID() : null));
            }
        }, new Function1<WinkNewMemoryAlbumResult, Unit>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.holder.new.BaseNewAlbumViewHolder$itemDtReport$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WinkNewMemoryAlbumResult winkNewMemoryAlbumResult) {
                invoke2(winkNewMemoryAlbumResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable WinkNewMemoryAlbumResult winkNewMemoryAlbumResult) {
                WinkNewMemoryAlbumResult winkNewMemoryAlbumResult2 = WinkNewMemoryAlbumResult.this;
                if (winkNewMemoryAlbumResult2 == null) {
                    return;
                }
                winkNewMemoryAlbumResult2.E(true);
            }
        });
    }
}
