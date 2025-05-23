package com.tencent.mobileqq.wink.inspirationlibrary.part.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.QQWinkPage;
import com.tencent.mobileqq.wink.QQWinkPageSwitchEvent;
import com.tencent.mobileqq.wink.event.UpdateMediaPickerBannerTagEvent;
import com.tencent.mobileqq.wink.view.RoundCornerImageView;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import feedcloud.FeedCloudActivityLandingPage$Topic;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 .2\u00020\u0001:\u0001/B\u001d\b\u0007\u0012\u0006\u0010)\u001a\u00020(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J*\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J*\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0005H\u0007J\u0006\u0010\u0014\u001a\u00020\u0002R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationTopicView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "initView", "K0", "", "count", "", "C0", "Landroid/view/View;", "view", "Lfeedcloud/FeedCloudActivityLandingPage$Topic;", "topic", "elementId", "topicIndex", "I0", "H0", "B0", "G0", "D0", "J0", "Lcom/tencent/mobileqq/wink/view/RoundCornerImageView;", "d", "Lcom/tencent/mobileqq/wink/view/RoundCornerImageView;", "topicPreview", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "topicTitle", "f", "topicDesc", "Landroid/widget/Button;", tl.h.F, "Landroid/widget/Button;", "publishBtn", "i", "Lfeedcloud/FeedCloudActivityLandingPage$Topic;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "curTopicIndex", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "D", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkInspirationTopicView extends ConstraintLayout {
    private static int E = ViewUtils.dpToPx(8.0f);
    private static int F = ViewUtils.dpToPx(4.0f);
    private static int G = ViewUtils.dpToPx(6.0f);

    @NotNull
    public Map<Integer, View> C;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RoundCornerImageView topicPreview;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView topicTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView topicDesc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Button publishBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedCloudActivityLandingPage$Topic topic;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int curTopicIndex;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkInspirationTopicView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void B0(FeedCloudActivityLandingPage$Topic topic) {
        HashMap<String, String> hashMap = new HashMap<>();
        String str = topic.f398426id.get();
        Intrinsics.checkNotNullExpressionValue(str, "topic.id.get()");
        hashMap.put("tagid", str);
        String str2 = topic.name.get();
        Intrinsics.checkNotNullExpressionValue(str2, "topic.name.get()");
        hashMap.put("tagname", str2);
        hashMap.put("feedtagpagefromtype", "101");
        hashMap.put("xsj_operation_activity_id", String.valueOf(WinkDatongCurrentParams.params.get("xsj_operation_activity_id")));
        com.tencent.mobileqq.wink.b.d().enterBySchemeAction(getContext(), QCircleScheme.Q_CIRCLE_ACTION_OPEN_CIRCLE_TAG_PAGE, hashMap);
    }

    private final String C0(int count) {
        if (count < 10000) {
            return String.valueOf(count);
        }
        if (count < 10000000) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%.1f\u4e07", Arrays.copyOf(new Object[]{Double.valueOf(count / 10000.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        if (count < 100000000) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%d\u4e07", Arrays.copyOf(new Object[]{Integer.valueOf(count / 10000)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return format2;
        }
        double d16 = count / 1.0E8d;
        if (d16 > 9999.0d) {
            return "9999\u4ebf";
        }
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String format3 = String.format("%.1f\u4ebf", Arrays.copyOf(new Object[]{Double.valueOf(d16)}, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
        return format3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(WinkInspirationTopicView this$0, FeedCloudActivityLandingPage$Topic topic, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(topic, "$topic");
        this$0.B0(topic);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(WinkInspirationTopicView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void G0() {
        String str;
        String str2;
        QPublicFragmentActivity qPublicFragmentActivity;
        String str3;
        Intent intent;
        HashMap hashMap;
        FeedCloudActivityLandingPage$Topic feedCloudActivityLandingPage$Topic = this.topic;
        if (feedCloudActivityLandingPage$Topic != null) {
            String str4 = feedCloudActivityLandingPage$Topic.name.get();
            String str5 = "";
            if (str4 == null) {
                str4 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str4, "it.name.get()?:\"\"");
            }
            String str6 = feedCloudActivityLandingPage$Topic.publish_schema.get();
            if (str6 == null) {
                str6 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str6, "it.publish_schema.get() ?: \"\"");
            }
            Uri parse = Uri.parse(str6);
            boolean z16 = true;
            try {
                String queryParameter = parse.getQueryParameter("taskid");
                if (queryParameter == null) {
                    queryParameter = "";
                }
                str = queryParameter;
            } catch (Exception e16) {
                QLog.e("WinkInspirationTopicView", 1, "jumpPublish parse taskid error:" + e16);
                str = "";
            }
            Intrinsics.checkNotNullExpressionValue(str, "try {\n                ur\u2026         \"\"\n            }");
            try {
                String queryParameter2 = parse.getQueryParameter(QCircleScheme.AttrQQPublish.CHALLENGE_TAG);
                if (queryParameter2 == null) {
                    queryParameter2 = "";
                }
                str2 = queryParameter2;
            } catch (Exception e17) {
                QLog.e("WinkInspirationTopicView", 1, "jumpPublish parse challengeName error:" + e17);
                str2 = "";
            }
            Intrinsics.checkNotNullExpressionValue(str2, "try {\n                ur\u2026         \"\"\n            }");
            try {
                String queryParameter3 = parse.getQueryParameter(QCircleScheme.AttrQQPublish.CHALLENGE_NUMS);
                if (queryParameter3 != null) {
                    str5 = queryParameter3;
                }
            } catch (Exception e18) {
                QLog.e("WinkInspirationTopicView", 1, "jumpPublish parse challengeNum error:" + e18);
            }
            Intrinsics.checkNotNullExpressionValue(str5, "try {\n                ur\u2026         \"\"\n            }");
            Context context = getContext();
            HashMap hashMap2 = null;
            if (context instanceof QPublicFragmentActivity) {
                qPublicFragmentActivity = (QPublicFragmentActivity) context;
            } else {
                qPublicFragmentActivity = null;
            }
            if (qPublicFragmentActivity != null && (intent = qPublicFragmentActivity.getIntent()) != null) {
                Intrinsics.checkNotNullExpressionValue(intent, "intent");
                String str7 = str2;
                str3 = str;
                com.tencent.mobileqq.wink.tag.a.c(com.tencent.mobileqq.wink.tag.a.f326414a, intent, str4, null, 4, null);
                if (str7.length() <= 0) {
                    z16 = false;
                }
                if (z16) {
                    Serializable serializableExtra = intent.getSerializableExtra("key_attrs");
                    if (serializableExtra instanceof HashMap) {
                        hashMap = (HashMap) serializableExtra;
                    } else {
                        hashMap = null;
                    }
                    if (hashMap != null) {
                        hashMap.put(QCircleScheme.AttrQQPublish.CHALLENGE_TAG, str7);
                        hashMap.put(QCircleScheme.AttrQQPublish.CHALLENGE_NUMS, str5);
                        hashMap.put("taskid", str3);
                        hashMap2 = hashMap;
                    }
                    intent.putExtra("key_attrs", hashMap2);
                }
            } else {
                str3 = str;
            }
            SimpleEventBus.getInstance().dispatchEvent(new QQWinkPageSwitchEvent(QQWinkPage.MediaPicker));
            SimpleEventBus.getInstance().dispatchEvent(new UpdateMediaPickerBannerTagEvent(str4, str3));
        }
    }

    private final void H0(View view, FeedCloudActivityLandingPage$Topic topic, String elementId, int topicIndex) {
        String str;
        boolean z16;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        String str2 = null;
        if (topic != null && (pBStringField2 = topic.f398426id) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            str = "";
        }
        if (topic != null && (pBStringField = topic.name) != null) {
            str2 = pBStringField.get();
        }
        if (str2 != null) {
            str3 = str2;
        }
        boolean z17 = false;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (str3.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                VideoReport.setElementId(view, elementId);
                VideoReport.setElementParam(view, "xsj_topic_id", str);
                VideoReport.setElementParam(view, "xsj_topic_name", str3);
                VideoReport.setElementParam(view, "xsj_topic_index", Integer.valueOf(topicIndex));
                VideoReport.setElementReuseIdentifier(view, str3);
                VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
                return;
            }
        }
        QLog.e("WinkInspirationTopicView", 1, "[registerDatongElement] invalid id or name.");
    }

    private final void I0(View view, FeedCloudActivityLandingPage$Topic topic, String elementId, int topicIndex) {
        String str;
        boolean z16;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        String str2 = null;
        if (topic != null && (pBStringField2 = topic.f398426id) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            str = "";
        }
        if (topic != null && (pBStringField = topic.name) != null) {
            str2 = pBStringField.get();
        }
        if (str2 != null) {
            str3 = str2;
        }
        boolean z17 = false;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (str3.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                VideoReport.setElementId(view, elementId);
                VideoReport.setElementParam(view, "xsj_topic_id", str);
                VideoReport.setElementParam(view, "xsj_topic_name", str3);
                VideoReport.setElementParam(view, "xsj_topic_index", Integer.valueOf(topicIndex));
                VideoReport.setElementReuseIdentifier(view, str3);
                VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
                return;
            }
        }
        QLog.e("WinkInspirationTopicView", 1, "[registerDatongElement] invalid id or name.");
    }

    private final void K0() {
        TextView textView = this.topicTitle;
        if (textView != null) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.setMarginStart(ViewUtils.dip2px(10.0f));
            textView.setLayoutParams(layoutParams2);
        }
        TextView textView2 = this.topicDesc;
        if (textView2 != null) {
            ViewGroup.LayoutParams layoutParams3 = textView2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
            layoutParams4.setMarginStart(ViewUtils.dip2px(10.0f));
            textView2.setLayoutParams(layoutParams4);
        }
    }

    private final void initView() {
        View inflate = View.inflate(getContext(), R.layout.i5u, this);
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) inflate.findViewById(R.id.f100355s_);
        this.topicPreview = roundCornerImageView;
        if (roundCornerImageView != null) {
            roundCornerImageView.setCorner(G);
        }
        this.topicTitle = (TextView) inflate.findViewById(R.id.juh);
        this.topicDesc = (TextView) inflate.findViewById(R.id.f100265s1);
        Button button = (Button) inflate.findViewById(R.id.f100315s6);
        this.publishBtn = button;
        if (button != null) {
            int i3 = E;
            button.setPadding(i3, 0, i3, 0);
        }
        K0();
    }

    @SuppressLint({"SetTextI18n"})
    public final void D0(@NotNull final FeedCloudActivityLandingPage$Topic topic, int topicIndex) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        this.topic = topic;
        this.curTopicIndex = topicIndex;
        if (topic.feed_items.size() > 0) {
            String str = topic.feed_items.get().get(0).pic.picUrl.get();
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain.mFailedDrawable = drawable;
            obtain.mLoadingDrawable = drawable;
            RoundCornerImageView roundCornerImageView = this.topicPreview;
            if (roundCornerImageView != null) {
                roundCornerImageView.setImageDrawable(URLDrawable.getDrawable(str, obtain));
            }
        }
        TextView textView = this.topicTitle;
        if (textView != null) {
            textView.setText("#" + topic.name.get());
        }
        TextView textView2 = this.topicDesc;
        if (textView2 != null) {
            textView2.setText(C0(topic.play_count.get()) + "\u6d4f\u89c8 | " + C0(topic.feed_count.get()) + "\u4f5c\u54c1");
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.inspirationlibrary.part.view.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkInspirationTopicView.E0(WinkInspirationTopicView.this, topic, view);
            }
        });
        Button button = this.publishBtn;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.inspirationlibrary.part.view.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkInspirationTopicView.F0(WinkInspirationTopicView.this, view);
                }
            });
        }
        H0(this, topic, "em_xsj_topic_item", this.curTopicIndex + 1);
        Button button2 = this.publishBtn;
        if (button2 != null) {
            H0(button2, topic, "em_xsj_publish_button", this.curTopicIndex + 1);
        }
    }

    public final void J0() {
        I0(this, this.topic, "em_xsj_topic_item", this.curTopicIndex + 1);
        Button button = this.publishBtn;
        if (button != null) {
            I0(button, this.topic, "em_xsj_publish_button", this.curTopicIndex + 1);
        }
        VideoReport.traverseExposure();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkInspirationTopicView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.C = new LinkedHashMap();
        initView();
    }

    public /* synthetic */ WinkInspirationTopicView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}
