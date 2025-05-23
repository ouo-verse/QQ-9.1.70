package m40;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.widgets.QFSPressEffectImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0016J(\u0010\u001b\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u00190\u0018j\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u0019`\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lm40/a;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "Landroid/view/View$OnClickListener;", "feed", "", "k1", "Lcom/tencent/biz/qqcircle/beans/QFSCommentInfo;", "h1", "", "g1", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "i1", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "N0", "data", "position", "j1", "v", NodeProps.ON_CLICK, "simpleBaseEvent", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "", "w0", "Landroid/widget/LinearLayout;", "I", "Landroid/widget/LinearLayout;", "commentLayout", "Lcom/tencent/biz/qqcircle/widgets/QFSPressEffectImageView;", "J", "Lcom/tencent/biz/qqcircle/widgets/QFSPressEffectImageView;", "commentView", "Landroid/widget/TextView;", "K", "Landroid/widget/TextView;", "commentNum", "L", "Ljava/lang/String;", "contentType", "<init>", "()V", "M", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {

    /* renamed from: I, reason: from kotlin metadata */
    private LinearLayout commentLayout;

    /* renamed from: J, reason: from kotlin metadata */
    private QFSPressEffectImageView commentView;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView commentNum;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private String contentType = "";

    private final int g1() {
        String str = this.contentType;
        if (Intrinsics.areEqual(str, "article")) {
            return 15;
        }
        if (Intrinsics.areEqual(str, "feed")) {
            return 16;
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final QFSCommentInfo h1() {
        QFSCommentInfo qFSCommentInfo = new QFSCommentInfo();
        qFSCommentInfo.mFeedBlockData = new e30.b((FeedCloudMeta$StFeed) this.f85017h);
        qFSCommentInfo.mFeed = (FeedCloudMeta$StFeed) this.f85017h;
        qFSCommentInfo.mRelocationScrollType = 100;
        qFSCommentInfo.mReportBean = getReportBean();
        qFSCommentInfo.mExtraTypeInfo = r();
        qFSCommentInfo.mCmtPanelSource = g1();
        qFSCommentInfo.mIsShowMask = true;
        return qFSCommentInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void i1(SimpleBaseEvent event) {
        T t16;
        if ((event instanceof QCircleCommentUpdateEvent) && (t16 = this.f85017h) != 0) {
            QCircleCommentUpdateEvent qCircleCommentUpdateEvent = (QCircleCommentUpdateEvent) event;
            if (TextUtils.equals(qCircleCommentUpdateEvent.feedId, ((FeedCloudMeta$StFeed) t16).f398449id.get())) {
                int i3 = ((FeedCloudMeta$StFeed) this.f85017h).commentCount.get();
                int i16 = qCircleCommentUpdateEvent.eventStatus;
                if (i16 == 4 || i16 == 6) {
                    if (i3 <= 0) {
                        i3 = 0;
                    } else {
                        i3--;
                    }
                }
                if (i16 == 3 || i16 == 5) {
                    i3++;
                }
                ((FeedCloudMeta$StFeed) this.f85017h).commentCount.set(i3);
                T mData = this.f85017h;
                Intrinsics.checkNotNullExpressionValue(mData, "mData");
                k1((FeedCloudMeta$StFeed) mData);
            }
        }
    }

    private final void k1(FeedCloudMeta$StFeed feed) {
        TextView textView = null;
        if (feed.commentCount.get() <= 0) {
            TextView textView2 = this.commentNum;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commentNum");
                textView2 = null;
            }
            textView2.setText(R.string.f183253io);
            TextView textView3 = this.commentNum;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commentNum");
            } else {
                textView = textView3;
            }
            textView.setContentDescription(com.tencent.biz.qqcircle.utils.h.a(R.string.f183253io));
            return;
        }
        TextView textView4 = this.commentNum;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentNum");
            textView4 = null;
        }
        textView4.setText(com.tencent.biz.qqcircle.immersive.utils.r.f(feed.commentCount.get()));
        TextView textView5 = this.commentNum;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentNum");
            textView5 = null;
        }
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f187793uy);
        TextView textView6 = this.commentNum;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentNum");
        } else {
            textView = textView6;
        }
        textView5.setContentDescription(a16 + ((Object) textView.getText()));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.N0(rootView);
        View findViewById = rootView.findViewById(R.id.f45731so);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026near_feed_comment_layout)");
        this.commentLayout = (LinearLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f45741sp);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026r_feed_feed_comment_icon)");
        this.commentView = (QFSPressEffectImageView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f45751sq);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026r_feed_feed_comment_text)");
        this.commentNum = (TextView) findViewById3;
        LinearLayout linearLayout = this.commentLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentLayout");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCircleCommentUpdateEvent.class);
        Intrinsics.checkNotNullExpressionValue(eventClass, "eventClass");
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull FeedCloudMeta$StFeed data, int position) {
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        super.L0(data, position);
        k1(data);
        Object b16 = this.E.b("KEY_LINEAR_FEED_CONTENT_TYPE");
        LinearLayout linearLayout = null;
        if (b16 instanceof String) {
            str = (String) b16;
        } else {
            str = null;
        }
        if (str != null) {
            this.contentType = str;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_CONTENT_TYPE, this.contentType);
        LinearLayout linearLayout2 = this.commentLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentLayout");
        } else {
            linearLayout = linearLayout2;
        }
        g0(linearLayout, QCircleDaTongConstant.ElementId.EM_XSJ_COMMENT_BUTTON, hashMap);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(v3);
        TextView textView = this.commentNum;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentNum");
            textView = null;
        }
        boolean equals = TextUtils.equals(textView.getText(), com.tencent.biz.qqcircle.utils.h.a(R.string.f183253io));
        t40.a s06 = s0();
        if (s06 != null) {
            if (equals) {
                str = "event_open_comment_input";
            } else {
                str = "event_open_comment";
            }
            s06.onHandlerMessage(str, h1());
        }
        R0(6, 2, r(), "");
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        i1(simpleBaseEvent);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSLinearFeedCommentPresenter";
    }
}
