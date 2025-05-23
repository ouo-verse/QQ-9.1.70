package com.tencent.biz.qqcircle.comment.emoji;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QFSCommentKeyboardEmoticonBean;
import com.tencent.biz.qqcircle.comment.af;
import com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper;
import com.tencent.biz.qqcircle.comment.at.bean.QFSCommentAtEntity;
import com.tencent.biz.qqcircle.comment.emoji.t;
import com.tencent.biz.qqcircle.comment.recpic.QFSCommentRecPicClusterHelper;
import com.tencent.biz.qqcircle.comment.recpic.aa;
import com.tencent.biz.qqcircle.comment.recpic.ak;
import com.tencent.biz.qqcircle.comment.recpic.sorter.StrategyImage;
import com.tencent.biz.qqcircle.events.QFSRecPicStateEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QFSAsyncUtils;
import com.tencent.biz.qqcircle.utils.cu;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarListView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.qcircle.api.global.QFSCommentEffectConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.widget.QzoneEmotionUtils;
import feedcloud.FeedCloudMeta$StFeed;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qqcircle.QQCircleEnvHub$CommentEffectInfo;
import qqcircle.QQCircleEnvHub$RecommendReplyText;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentFastToolsView extends LinearLayout implements SimpleEventReceiver<SimpleBaseEvent> {
    private static final int E = cx.a(30.0f);
    private static final String F = com.tencent.biz.qqcircle.utils.h.a(R.string.f188963y4);
    private static final List<QFSCommentKeyboardEmoticonBean> G = new ArrayList();
    private static int H;
    private boolean C;
    private boolean D;

    /* renamed from: d, reason: collision with root package name */
    private g f83592d;

    /* renamed from: e, reason: collision with root package name */
    private QCircleReportBean f83593e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f83594f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f83595h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f83596i;

    /* renamed from: m, reason: collision with root package name */
    private FeedCloudMeta$StFeed f83597m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f83598d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f83599e;

        a(boolean z16, View view) {
            this.f83598d = z16;
            this.f83599e = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            aa.f83750a.O();
            if (this.f83598d) {
                ak.f83788a.d(this.f83599e, QFSCommentFastToolsView.this.f83597m, QFSCommentFastToolsView.this.D(), QCircleDaTongConstant.ElementParamValue.PERMISSION, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f83601d;

        b(View view) {
            this.f83601d = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            aa.f83750a.P();
            this.f83601d.findViewById(R.id.f166986jo4).setVisibility(8);
            ak.f83788a.d(this.f83601d, QFSCommentFastToolsView.this.f83597m, QFSCommentFastToolsView.this.D(), "no_rec", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f83603d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QFSCommentKeyboardEmoticonBean f83604e;

        c(ImageView imageView, QFSCommentKeyboardEmoticonBean qFSCommentKeyboardEmoticonBean) {
            this.f83603d = imageView;
            this.f83604e = qFSCommentKeyboardEmoticonBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QFSCommentFastToolsView.this.f83592d != null) {
                QFSCommentFastToolsView.this.f83592d.a(this.f83603d, this.f83604e);
            }
            QFSCommentFastToolsView.this.u(this.f83604e, false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements t.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.qqcircle.comment.abovebar.d f83606a;

        d(com.tencent.biz.qqcircle.comment.abovebar.d dVar) {
            this.f83606a = dVar;
        }

        @Override // com.tencent.biz.qqcircle.comment.emoji.t.b
        public void a(@NonNull String str) {
            this.f83606a.f83313i.f421803k = true;
            if (QFSCommentFastToolsView.this.f83592d != null) {
                QFSCommentFastToolsView.this.f83592d.c(QzoneEmotionUtils.emCodesToQQcodes(str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e extends QFSAsyncUtils.Callback<Void, List<String>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.qqcircle.comment.abovebar.d f83608a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ t f83609b;

        e(com.tencent.biz.qqcircle.comment.abovebar.d dVar, t tVar) {
            this.f83608a = dVar;
            this.f83609b = tVar;
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<String> doBackgroundAction(Void... voidArr) {
            return QFSCommentFastToolsView.this.R(this.f83608a);
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void doMainAction(List<String> list) {
            this.f83609b.setData(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f83611d;

        f(List list) {
            this.f83611d = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QFSCommentFastToolsView.this.f83592d != null) {
                o20.c cVar = new o20.c(o20.c.f421786g);
                cVar.i(this.f83611d);
                QFSCommentFastToolsView.this.f83592d.b(cVar);
            }
            QFSCommentFastToolsView.this.w(false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface g {
        void a(ImageView imageView, QFSCommentKeyboardEmoticonBean qFSCommentKeyboardEmoticonBean);

        void b(o20.c cVar);

        void c(String str);
    }

    static {
        int i3 = SystemAndEmojiEmoticonInfo.COLUMNNUM_SYSTEM_AND_EMOJI;
        H = i3;
        String[] split = com.tencent.biz.qqcircle.f.o().split(",");
        int min = Math.min(split.length, i3);
        for (int i16 = 0; i16 < min; i16++) {
            String str = split[i16];
            int c16 = cu.c(str, -1);
            if (c16 == -1) {
                RFWLog.w("QFSCommentFastToolsView", RFWLog.USR, "parseStr2Int error, str=" + str);
            } else {
                int convertToLocal = QQSysFaceUtil.convertToLocal(c16);
                G.add(new QFSCommentKeyboardEmoticonBean(c16, convertToLocal, QQSysFaceUtil.getFaceDescription(convertToLocal)));
            }
        }
    }

    public QFSCommentFastToolsView(@NonNull Context context) {
        this(context, null);
    }

    private int A() {
        if (this.f83596i) {
            return 6;
        }
        if (!this.f83594f) {
            return SystemAndEmojiEmoticonInfo.COLUMNNUM_SYSTEM_AND_EMOJI;
        }
        if (this.f83595h) {
            return 6;
        }
        return 5;
    }

    private String B(@NonNull com.tencent.biz.qqcircle.comment.abovebar.d dVar) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        o20.d dVar2 = dVar.f83313i;
        if (dVar2 != null && (feedCloudMeta$StFeed = dVar2.f421797e) != null) {
            String str = feedCloudMeta$StFeed.subCate.get();
            QLog.d("QFSCommentFastToolsView", 1, "[getAiCommentsCache] category: " + str);
            return str;
        }
        QLog.e("QFSCommentFastToolsView", 1, "[getAiCommentsCache] report bean == null ");
        return "";
    }

    private String C() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f83597m;
        if (feedCloudMeta$StFeed != null) {
            return feedCloudMeta$StFeed.f398449id.get();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String D() {
        QCircleReportBean qCircleReportBean = this.f83593e;
        if (qCircleReportBean != null && qCircleReportBean.getDtPageId() != null) {
            return this.f83593e.getDtPageId();
        }
        return "";
    }

    private void E(SimpleBaseEvent simpleBaseEvent) {
        if ((simpleBaseEvent instanceof QFSRecPicStateEvent) && ((QFSRecPicStateEvent) simpleBaseEvent).getState() == 4) {
            t(100);
        }
    }

    private void F(SimpleBaseEvent simpleBaseEvent) {
        if ((simpleBaseEvent instanceof QFSRecPicStateEvent) && ((QFSRecPicStateEvent) simpleBaseEvent).getState() == 7) {
            this.C = true;
        }
    }

    private void G(SimpleBaseEvent simpleBaseEvent) {
        if ((simpleBaseEvent instanceof QFSRecPicStateEvent) && ((QFSRecPicStateEvent) simpleBaseEvent).getState() == 1) {
            V();
        }
    }

    private void H(SimpleBaseEvent simpleBaseEvent) {
        if ((simpleBaseEvent instanceof QFSRecPicStateEvent) && ((QFSRecPicStateEvent) simpleBaseEvent).getState() == 2) {
            s(true);
        }
    }

    private boolean I() {
        return QFSCommentRecPicClusterHelper.f83716a.J(C());
    }

    private void J() {
        if (!com.tencent.biz.qqcircle.f.k()) {
            setVisibility(8);
            RFWLog.d("QFSCommentFastToolsView", RFWLog.USR, "enableShowCommentKeyboardEmojFromWNS false");
        } else {
            setVisibility(0);
            setOrientation(0);
        }
    }

    private void K(RecyclerView recyclerView, com.tencent.biz.qqcircle.comment.abovebar.d dVar) {
        List<String> Q;
        t tVar = new t();
        recyclerView.setAdapter(tVar);
        tVar.n0(new d(dVar));
        o20.d dVar2 = dVar.f83313i;
        if (dVar2 != null) {
            tVar.o0(dVar2);
        }
        if (TextUtils.equals(com.tencent.biz.qqcircle.utils.l.b("exp_comment_ai_recommend"), "exp_comment_ai_recommend_B")) {
            Q = z(dVar);
        } else {
            Q = Q(dVar);
        }
        if (RFSafeListUtils.isEmpty(Q)) {
            QLog.d("QFSCommentFastToolsView", 1, "[initQuickCmtAdapter] parse json file. ");
            QFSAsyncUtils.executeSub(new e(dVar, tVar), new Void[0]);
        } else {
            tVar.setData(Q);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(View view, View view2, View view3) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view3);
        if ((view3.getContext() instanceof Activity) && aa.f83750a.E((Activity) getContext())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (I()) {
                ak.f83788a.d(view, this.f83597m, D(), "rec", false);
                SimpleEventBus.getInstance().dispatchEvent(new QFSRecPicStateEvent(3, C()));
            } else {
                ak.f83788a.d(view, this.f83597m, D(), "rec", false);
                QCircleToast.l(QCircleToast.f91644d, com.tencent.biz.qqcircle.utils.h.a(R.string.f170892m_), 0, true, false);
            }
        } else {
            view2.setVisibility(8);
            ak.f83788a.d(view, this.f83597m, D(), QCircleDaTongConstant.ElementParamValue.PERMISSION, false);
            aa.f83750a.R(getContext(), C(), "rec_outside", D());
        }
        EventCollector.getInstance().onViewClicked(view3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void M(View view, View view2, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        QLog.d("QFSCommentFastToolsView", 4, "[dismissEntranceTxtAnim] width: " + intValue);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = intValue;
        view.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
        layoutParams2.width = intValue;
        view2.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(final View view, final View view2) {
        ValueAnimator duration = ValueAnimator.ofInt(DisplayUtil.dip2px(view.getContext(), 96.0f), DisplayUtil.dip2px(view.getContext(), 30.0f)).setDuration(250L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.comment.emoji.k
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QFSCommentFastToolsView.M(view, view2, valueAnimator);
            }
        });
        duration.addListener(new b(view));
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(View view, float f16, boolean z16) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "TranslationX", f16, 0.0f);
        ofFloat.setDuration(250L);
        ofFloat.addListener(new a(z16, view));
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P(TextView textView, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = intValue;
        textView.setLayoutParams(layoutParams);
    }

    private List<String> Q(com.tencent.biz.qqcircle.comment.abovebar.d dVar) {
        ArrayList arrayList = new ArrayList();
        QQCircleEnvHub$CommentEffectInfo commentEffectInfo = QFSCommentEffectConfig.getCommentEffectInfo();
        if (commentEffectInfo == null) {
            QLog.d("QFSCommentFastToolsView", 1, "[initQuickReplyAndEmojiAdapter] commentEffectInfo = null");
            return arrayList;
        }
        if (dVar.f83308d) {
            List<QQCircleEnvHub$RecommendReplyText> list = commentEffectInfo.inputToolsBarConfigInfo.recommendReplyText.get();
            for (int i3 = 0; i3 < 4; i3++) {
                for (QQCircleEnvHub$RecommendReplyText qQCircleEnvHub$RecommendReplyText : list) {
                    if (i3 == 0) {
                        Collections.shuffle(qQCircleEnvHub$RecommendReplyText.replyTexts.get());
                    }
                    if (i3 >= qQCircleEnvHub$RecommendReplyText.replyTexts.size()) {
                        return y(arrayList);
                    }
                    arrayList.add(qQCircleEnvHub$RecommendReplyText.replyTexts.get(i3));
                }
            }
        }
        return y(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> R(@NonNull com.tencent.biz.qqcircle.comment.abovebar.d dVar) {
        List<String> z16 = z(dVar);
        if (z16 != null) {
            return z16;
        }
        ArrayList arrayList = new ArrayList();
        String resourcePath = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).getResourcePath("qqcircle_input_tools_bar_ai_recomm_content");
        if (TextUtils.isEmpty(resourcePath)) {
            return Q(dVar);
        }
        String B = B(dVar);
        if (TextUtils.isEmpty(B)) {
            return Q(dVar);
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(resourcePath)));
            StringBuilder sb5 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb5.append(readLine);
            }
            JSONArray jSONArray = new JSONObject(sb5.toString()).getJSONArray(B);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                Object obj = jSONArray.get(i3);
                if (obj instanceof String) {
                    arrayList.add((String) obj);
                }
            }
        } catch (IOException e16) {
            QLog.e("QFSCommentFastToolsView", 1, "[parseQuickAiComments] read file exception: " + e16);
        } catch (JSONException e17) {
            QLog.e("QFSCommentFastToolsView", 1, "[parseQuickAiComments] parse json exception: " + e17);
        }
        if (RFSafeListUtils.isEmpty(arrayList)) {
            return Q(dVar);
        }
        dVar.f83313i.f421802j = 1;
        com.tencent.biz.qqcircle.comment.h.G().p(B, arrayList);
        Collections.shuffle(arrayList);
        return y(arrayList);
    }

    private void S(@NonNull ImageView imageView) {
        List<StrategyImage> G2 = QFSCommentRecPicClusterHelper.f83716a.G(C());
        if (RFSafeListUtils.isEmpty(G2)) {
            imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.nqu, null));
            return;
        }
        Option obtain = Option.obtain();
        obtain.setUrl(G2.get(0).getPath()).setTargetView(imageView);
        QCircleFeedPicLoader.g().loadImage(obtain);
    }

    private void T(final View view, final float f16, final boolean z16) {
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.emoji.n
            @Override // java.lang.Runnable
            public final void run() {
                QFSCommentFastToolsView.this.O(view, f16, z16);
            }
        }, 2000L);
    }

    private void U() {
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f158631q5);
        final TextView textView = (TextView) findViewById(R.id.f166986jo4);
        View findViewById = findViewById(R.id.lgf);
        if (textView != null && textView.getVisibility() != 0 && findViewById != null) {
            findViewById.setVisibility(0);
            textView.setText(a16);
            textView.measure(0, 0);
            int measuredWidth = textView.getMeasuredWidth();
            QLog.d("QFSCommentFastToolsView", 1, "[showHasCandidateAnim] measureWidth: " + measuredWidth);
            ValueAnimator ofInt = ValueAnimator.ofInt(0, measuredWidth);
            ofInt.setDuration(250L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.comment.emoji.l
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    QFSCommentFastToolsView.P(textView, valueAnimator);
                }
            });
            ofInt.start();
        }
    }

    private void V() {
        QLog.d("QFSCommentFastToolsView", 1, "[showLoadingState] ");
        TextView textView = (TextView) findViewById(R.id.f166986jo4);
        View findViewById = findViewById(R.id.lgf);
        View findViewById2 = findViewById(R.id.f72013pp);
        if (textView != null && findViewById != null) {
            s(false);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.width = DisplayUtil.dip2px(getContext(), 96.0f);
            layoutParams.height = -2;
            findViewById.setLayoutParams(layoutParams);
            textView.setVisibility(0);
            findViewById2.setVisibility(8);
            textView.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f184163l5));
            ak.f83788a.d(findViewById, this.f83597m, D(), ToastView.ICON_LOADING, true);
            t(2000);
            aa aaVar = aa.f83750a;
            aaVar.P();
            aaVar.O();
        }
    }

    private void l(ViewGroup viewGroup) {
        H = A();
        for (int i3 = 0; i3 < H; i3++) {
            QFSCommentKeyboardEmoticonBean qFSCommentKeyboardEmoticonBean = G.get(i3);
            ImageView imageView = new ImageView(getContext());
            imageView.setImageDrawable(QQSysFaceUtil.getFaceDrawable(qFSCommentKeyboardEmoticonBean.getLocalId()));
            int i16 = E;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i16, i16);
            layoutParams.weight = 1.0f;
            viewGroup.addView(imageView, layoutParams);
            imageView.setOnClickListener(new c(imageView, qFSCommentKeyboardEmoticonBean));
        }
    }

    private void m(com.tencent.biz.qqcircle.comment.abovebar.d dVar) {
        boolean z16;
        int i3;
        if (dVar.f83310f && !dVar.f83311g) {
            z16 = true;
        } else {
            z16 = false;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        if (z16) {
            i3 = DisplayUtil.getScreenWidth();
        } else {
            i3 = -1;
        }
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(i3, -1));
        l(linearLayout);
        addView(linearLayout);
        if (z16) {
            float f16 = -DisplayUtil.dip2px(getContext(), 100.0f);
            linearLayout.setTranslationX(f16);
            T(linearLayout, f16, false);
        }
    }

    private void n(@NonNull com.tencent.biz.qqcircle.comment.abovebar.d dVar) {
        boolean z16;
        int i3;
        int i16;
        String str;
        List<QFSCommentAtEntity> l06 = QFSCommentAtHelper.l0();
        int size = RFSafeListUtils.getSize(l06);
        boolean Q = com.tencent.biz.qqcircle.comment.h.G().Q();
        int i17 = 0;
        if (Q && size != 0 && !QFSCommentAtHelper.i0() && !QFSCommentAtHelper.f0()) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("QFSCommentFastToolsView", 1, "[addFastAtView] isChangeAtStyle = " + z16 + ", mFastAtUserCount = " + size + ", isInExp =" + Q);
        if (dVar.f83305a && !z16) {
            return;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.g9b, (ViewGroup) this, false);
        if (inflate == null) {
            QLog.e("QFSCommentFastToolsView", 1, "[addFastAtView] fastAtView should not be null");
            return;
        }
        inflate.setBackground(af.j(R.color.qui_common_bg_middle_light, R.color.qui_common_text_secondary));
        inflate.setOnClickListener(new f(l06));
        TextView textView = (TextView) inflate.findViewById(R.id.f353811p);
        QCircleAvatarListView qCircleAvatarListView = (QCircleAvatarListView) inflate.findViewById(R.id.f353611n);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.f353711o);
        TextView textView2 = (TextView) inflate.findViewById(R.id.f353911q);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.f354111s);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.f354211t);
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f195634f5);
        imageView.setVisibility(0);
        imageView2.setVisibility(8);
        frameLayout.setVisibility(8);
        if (!z16) {
            textView.setText(a16);
            qCircleAvatarListView.setVisibility(8);
            this.f83595h = true;
        } else if (size == 1) {
            if (dVar.f83305a) {
                QFSCommentAtEntity qFSCommentAtEntity = l06.get(0);
                if (TextUtils.isEmpty(qFSCommentAtEntity.name)) {
                    str = qFSCommentAtEntity.uin;
                } else {
                    str = qFSCommentAtEntity.name;
                }
                textView.setText(str);
                qCircleAvatarListView.setVisibility(8);
            } else {
                textView.setText(a16);
                qCircleAvatarListView.setVisibility(0);
                qCircleAvatarListView.setData(com.tencent.biz.qqcircle.utils.o.a(l06, 3));
            }
        } else if (size > 1) {
            if (dVar.f83305a) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            imageView.setVisibility(i3);
            if (dVar.f83305a) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            imageView2.setVisibility(i16);
            if (dVar.f83305a) {
                a16 = F;
            }
            textView.setText(a16);
            qCircleAvatarListView.setVisibility(0);
            qCircleAvatarListView.setData(com.tencent.biz.qqcircle.utils.o.a(l06, 3));
            if (size <= 3) {
                i17 = 8;
            }
            frameLayout.setVisibility(i17);
            if (size > 3) {
                textView2.setText(String.valueOf(size));
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, cx.a(30.0f));
        if (dVar.f83306b && !dVar.f83307c) {
            layoutParams.rightMargin = cx.a(12.0f);
        }
        addView(inflate, layoutParams);
        this.f83594f = true;
    }

    private void o(@NonNull com.tencent.biz.qqcircle.comment.abovebar.d dVar) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.g9e, (ViewGroup) this, false);
        TextView textView = (TextView) inflate.findViewById(R.id.f356212c);
        if (this.f83594f) {
            textView.setVisibility(8);
        }
        inflate.findViewById(R.id.yns).setOnClickListener(dVar.f83312h);
        inflate.findViewById(R.id.yns).setBackground(af.j(R.color.qui_common_bg_middle_light, R.color.qui_common_text_secondary));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, cx.a(30.0f));
        inflate.setPadding(cx.a(12.0f), 0, 0, 0);
        addView(inflate, layoutParams);
    }

    private void p(com.tencent.biz.qqcircle.comment.abovebar.d dVar) {
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(getContext()).inflate(R.layout.g9d, (ViewGroup) this, false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(null);
        addView(recyclerView);
        K(recyclerView, dVar);
    }

    private void q(com.tencent.biz.qqcircle.comment.abovebar.d dVar) {
        boolean z16;
        final View inflate = LayoutInflater.from(getContext()).inflate(R.layout.g9k, (ViewGroup) this, false);
        addView(inflate);
        s(false);
        TextView textView = (TextView) inflate.findViewById(R.id.f166986jo4);
        final View findViewById = inflate.findViewById(R.id.f72013pp);
        findViewById.setVisibility(8);
        this.f83596i = true;
        if ((getContext() instanceof Activity) && aa.f83750a.E((Activity) getContext())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (dVar.f83311g) {
            V();
        } else if (dVar.f83310f) {
            this.f83596i = false;
            findViewById.setVisibility(0);
            textView.setVisibility(0);
            float f16 = -DisplayUtil.dip2px(getContext(), 119.0f);
            inflate.setTranslationX(f16);
            T(inflate, f16, true);
        } else {
            aa aaVar = aa.f83750a;
            if (aaVar.c()) {
                textView.setVisibility(0);
                t(2000);
                ak.f83788a.d(inflate, this.f83597m, D(), QCircleDaTongConstant.ElementParamValue.PERMISSION, true);
            } else if (aaVar.d()) {
                textView.setVisibility(0);
                aaVar.b();
                ak.f83788a.d(inflate, this.f83597m, D(), QCircleDaTongConstant.ElementParamValue.PERMISSION, true);
            } else if (!I() && z16) {
                this.f83596i = false;
                inflate.setVisibility(8);
            }
        }
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.comment.emoji.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSCommentFastToolsView.this.L(inflate, findViewById, view);
            }
        });
        x(inflate);
    }

    private void r(boolean z16) {
        if (z16) {
            setPadding(cx.a(12.0f), cx.a(12.0f), 0, 0);
        } else {
            setPadding(cx.a(12.0f), cx.a(12.0f), cx.a(12.0f), 0);
        }
    }

    private void s(boolean z16) {
        boolean z17;
        int i3;
        TextView textView = (TextView) findViewById(R.id.f166986jo4);
        ImageView imageView = (ImageView) findViewById(R.id.d_k);
        if (imageView != null && textView != null) {
            boolean z18 = true;
            if ((getContext() instanceof Activity) && aa.f83750a.E((Activity) getContext())) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                if (aa.f83750a.v()) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f160831w3));
                }
            } else if (I()) {
                if (this.C) {
                    i3 = R.string.f172722r8;
                } else {
                    i3 = R.string.f158631q5;
                }
                textView.setText(com.tencent.biz.qqcircle.utils.h.a(i3));
                if (this.D) {
                    ak.f83788a.d(textView, this.f83597m, D(), "rec", true);
                }
                this.D = true;
            }
            if (!I() && z17) {
                z18 = false;
            }
            if (z18) {
                S(imageView);
                if (z16 && z17) {
                    U();
                }
                textView.setVisibility(0);
                return;
            }
            String url = QCircleSkinHelper.getInstance().getUrl("qvideo_icon_comment_zhinengtuping_noobtain");
            Option obtain = Option.obtain();
            obtain.setTargetView(imageView).setUrl(url);
            QCircleFeedPicLoader.g().loadImage(obtain);
            textView.setVisibility(8);
        }
    }

    private void t(int i3) {
        final View findViewById = findViewById(R.id.lgf);
        final View findViewById2 = findViewById(R.id.f165104uw4);
        View findViewById3 = findViewById(R.id.f166986jo4);
        if (findViewById == null || findViewById3 == null || findViewById3.getVisibility() != 0) {
            return;
        }
        QLog.d("QFSCommentFastToolsView", 1, "[dismissEntranceTxtAnim] ");
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.emoji.j
            @Override // java.lang.Runnable
            public final void run() {
                QFSCommentFastToolsView.this.N(findViewById, findViewById2);
            }
        }, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(QFSCommentKeyboardEmoticonBean qFSCommentKeyboardEmoticonBean, boolean z16) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_EMOJI_ITEM);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_EMOJI_ID, Integer.valueOf(qFSCommentKeyboardEmoticonBean.getServerId()));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_EMOJI_NAME, qFSCommentKeyboardEmoticonBean.getDesc());
        QCircleReportBean qCircleReportBean = this.f83593e;
        if (qCircleReportBean != null) {
            buildElementParams.put("xsj_custom_pgid", qCircleReportBean.getDtPageId());
        }
        if (z16) {
            VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
        } else {
            VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
        }
    }

    private void v() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_EMOJI_OUTSIDE_KEYBOARD);
        QCircleReportBean qCircleReportBean = this.f83593e;
        if (qCircleReportBean != null) {
            buildElementParams.put("xsj_custom_pgid", qCircleReportBean.getDtPageId());
        }
        VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z16) {
        String str;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_QUICK_AT_BUTTON);
        QCircleReportBean qCircleReportBean = this.f83593e;
        if (qCircleReportBean != null) {
            buildElementParams.put("xsj_custom_pgid", qCircleReportBean.getDtPageId());
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AT_USER_NUM, Integer.valueOf(QFSCommentAtHelper.l0().size()));
        if (z16) {
            str = "ev_xsj_abnormal_imp";
        } else {
            str = "ev_xsj_abnormal_clck";
        }
        VideoReport.reportEvent(str, buildElementParams);
    }

    private void x(View view) {
        String str;
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_REC_PIC_OUTSIDE_BUTTON);
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_feed_id", C());
        if (aa.f83750a.E((Activity) getContext())) {
            str = "function";
        } else {
            str = QCircleDaTongConstant.ElementParamValue.PERMISSION;
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, str);
        VideoReport.setElementParams(view, hashMap);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private List<String> y(@NonNull List<String> list) {
        if (list.size() > 8) {
            return list.subList(0, 8);
        }
        return list;
    }

    private List<String> z(@NonNull com.tencent.biz.qqcircle.comment.abovebar.d dVar) {
        String B = B(dVar);
        if (TextUtils.isEmpty(B)) {
            return Q(dVar);
        }
        List<String> J = com.tencent.biz.qqcircle.comment.h.G().J(B);
        if (!RFSafeListUtils.isEmpty(J)) {
            o20.d dVar2 = dVar.f83313i;
            if (dVar2 != null) {
                dVar2.f421802j = 1;
            }
            Collections.shuffle(J);
            return y(J);
        }
        String resourcePath = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).getResourcePath("qqcircle_input_tools_bar_ai_recomm_content");
        QLog.d("QFSCommentFastToolsView", 1, "[parseQuickAiComments] path: " + resourcePath);
        if (TextUtils.isEmpty(resourcePath)) {
            return Q(dVar);
        }
        return null;
    }

    public void W(@NonNull com.tencent.biz.qqcircle.comment.abovebar.d dVar) {
        QLog.d("QFSCommentFastToolsView", 1, "config: " + dVar);
        removeAllViews();
        int i3 = 0;
        this.f83594f = false;
        this.f83595h = false;
        this.f83596i = false;
        if (dVar.f83309e) {
            l(this);
        } else {
            aa aaVar = aa.f83750a;
            if (aaVar.F() && !dVar.f83308d && aaVar.z(this.f83597m) && !aaVar.t()) {
                q(dVar);
                m(dVar);
                dVar.f83311g = false;
                dVar.f83310f = false;
            } else {
                n(dVar);
                if (dVar.f83307c) {
                    o(dVar);
                }
                if (dVar.f83308d) {
                    p(dVar);
                } else if (dVar.f83306b) {
                    l(this);
                }
            }
        }
        if (getChildCount() == 0) {
            i3 = 8;
        }
        setVisibility(i3);
        if (getChildCount() > 0) {
            r(dVar.f83308d);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QFSRecPicStateEvent.class);
        return arrayList;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        E(simpleBaseEvent);
        H(simpleBaseEvent);
        G(simpleBaseEvent);
        F(simpleBaseEvent);
    }

    public void setFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.f83597m = feedCloudMeta$StFeed;
    }

    public void setOnReplyClickListener(g gVar) {
        this.f83592d = gVar;
    }

    public void setReportBean(QCircleReportBean qCircleReportBean, boolean z16) {
        this.f83593e = qCircleReportBean;
        v();
        w(true);
        if (!z16) {
            Iterator<QFSCommentKeyboardEmoticonBean> it = G.iterator();
            while (it.hasNext()) {
                u(it.next(), true);
            }
        }
    }

    public QFSCommentFastToolsView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSCommentFastToolsView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        J();
    }
}
