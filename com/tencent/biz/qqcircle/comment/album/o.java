package com.tencent.biz.qqcircle.comment.album;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.comment.recpic.ak;
import com.tencent.biz.qqcircle.comment.recpic.sorter.StrategyImage;
import com.tencent.biz.qqcircle.helpers.u;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSCommentPicSelectEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/album/o;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "showRecIcon", "", "o", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "p", "Lcom/tencent/biz/qqcircle/comment/album/k;", "localMediaInfo", "", com.tencent.luggage.wxa.c8.c.G, "Lcooperation/qqcircle/report/QCircleReportBean;", "reportBean", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class o extends RecyclerView.ViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(QFSLocalMediaInfo localMediaInfo, LocalMediaInfo localMedia, int i3, o this$0, QCircleReportBean qCircleReportBean, View view) {
        String str;
        String str2;
        Map mutableMapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(localMediaInfo, "$localMediaInfo");
        Intrinsics.checkNotNullParameter(localMedia, "$localMedia");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str3 = "";
        if (localMediaInfo.getIsRec()) {
            ak akVar = ak.f83788a;
            String path = localMedia.getPath();
            if (path == null) {
                str = "";
            } else {
                str = path;
            }
            String path2 = localMedia.getPath();
            if (path2 == null) {
                str2 = "";
            } else {
                str2 = path2;
            }
            float score = localMediaInfo.getScore();
            int strategy = localMediaInfo.getStrategy();
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("index", Integer.valueOf(i3)));
            akVar.h(new StrategyImage(str, strategy, score, str2, mutableMapOf));
            View itemView = this$0.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            akVar.f(itemView, i3, localMediaInfo, qCircleReportBean, false);
        }
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        String path3 = localMedia.getPath();
        if (path3 != null) {
            str3 = path3;
        }
        simpleEventBus.dispatchEvent(new QFSCommentPicSelectEvent(str3, localMedia.getMediaWidth(), localMedia.getMediaHeight()));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void o(boolean showRecIcon) {
        int i3;
        ImageView imageView = (ImageView) this.itemView.findViewById(R.id.d_k);
        if (showRecIcon) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    private final void p(LocalMediaInfo info) {
        Option option = Option.obtain();
        View findViewById = this.itemView.findViewById(R.id.image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.image)");
        ImageView imageView = (ImageView) findViewById;
        u.f84666a.b(imageView);
        com.tencent.libra.util.a aVar = com.tencent.libra.util.a.f118813a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        aVar.q(option, true);
        option.setTargetView(imageView);
        option.setUrl(info.getPath());
        QCircleFeedPicLoader.g().loadImage(option);
    }

    public final void m(@NotNull final QFSLocalMediaInfo localMediaInfo, final int pos, @Nullable final QCircleReportBean reportBean) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        final LocalMediaInfo localMediaInfo2 = localMediaInfo.getLocalMediaInfo();
        p(localMediaInfo2);
        o(localMediaInfo.getIsRec());
        if (localMediaInfo.getIsRec()) {
            ak akVar = ak.f83788a;
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            akVar.f(itemView, pos, localMediaInfo, reportBean, true);
        }
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.comment.album.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.n(QFSLocalMediaInfo.this, localMediaInfo2, pos, this, reportBean, view);
            }
        });
        this.itemView.setContentDescription(com.tencent.qqnt.qbasealbum.query.b.c(com.tencent.qqnt.qbasealbum.query.b.f361494a, localMediaInfo2, null, 2, null));
    }
}
