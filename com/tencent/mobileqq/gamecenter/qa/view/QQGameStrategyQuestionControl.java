package com.tencent.mobileqq.gamecenter.qa.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.qa.api.IGameQAIpcApi;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi;
import com.tencent.mobileqq.gamecenter.qa.data.InviteData;
import com.tencent.mobileqq.gamecenter.qa.editor.span.AbsoluteSizeSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.span.AlignmentSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.span.BoldSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.span.ItalicSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.span.UnderlineSpan;
import com.tencent.mobileqq.gamecenter.qa.event.QASelectExpertsEvent;
import com.tencent.mobileqq.gamecenter.qa.manager.GameStrategyDraftHandler;
import com.tencent.mobileqq.gamecenter.qa.manager.b;
import com.tencent.mobileqq.gamecenter.qa.model.GameQALinkCardData;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyPic;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyQuestion;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyTag;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyVideo;
import com.tencent.mobileqq.gamecenter.qa.util.GameQAUtil;
import com.tencent.mobileqq.gamecenter.qa.view.GameStrategyImageSpan;
import com.tencent.mobileqq.gamecenter.qa.view.QQGameStrategyQuestionControl;
import com.tencent.mobileqq.gamecenter.qa.view.bh;
import com.tencent.mobileqq.gamecenter.qa.view.bj;
import com.tencent.mobileqq.gamecenter.qa.view.bk;
import com.tencent.mobileqq.gamecenter.qa.view.s;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
import xd1.a;
import yd1.b;
import yd1.c;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGameStrategyQuestionControl extends bh implements View.OnClickListener, SimpleEventReceiver {
    private EditText P0;
    private LinearLayout Q0;
    private TextView R0;
    private TextView S0;
    private ImageView T0;
    private ImageView U0;
    private TextView V0;
    private TextView W0;
    private RecyclerView X0;
    private RecyclerView Y0;
    private View Z0;

    /* renamed from: a1, reason: collision with root package name */
    private com.tencent.mobileqq.gamecenter.qa.model.i f212920a1;

    /* renamed from: b1, reason: collision with root package name */
    private fe1.c f212921b1;

    /* renamed from: c1, reason: collision with root package name */
    private GameStrategyDraftHandler f212922c1;

    /* renamed from: d1, reason: collision with root package name */
    private bk f212923d1;

    /* renamed from: e1, reason: collision with root package name */
    private bj f212924e1;

    /* renamed from: f1, reason: collision with root package name */
    private List<GameStrategyTag> f212925f1;

    /* renamed from: g1, reason: collision with root package name */
    private List<GameStrategyTag> f212926g1;

    /* renamed from: h1, reason: collision with root package name */
    private boolean f212927h1;

    /* renamed from: i1, reason: collision with root package name */
    private GameStrategyQuestion f212928i1;

    /* renamed from: j1, reason: collision with root package name */
    private final AtomicBoolean f212929j1;

    /* renamed from: k1, reason: collision with root package name */
    private View f212930k1;

    /* renamed from: l1, reason: collision with root package name */
    protected TextView f212931l1;

    /* renamed from: m1, reason: collision with root package name */
    private final ArrayList<InviteData> f212932m1;

    /* renamed from: n1, reason: collision with root package name */
    private final ArrayList<String> f212933n1;

    /* renamed from: o1, reason: collision with root package name */
    private final TextWatcher f212934o1;

    /* renamed from: p1, reason: collision with root package name */
    private fe1.d f212935p1;

    /* renamed from: q1, reason: collision with root package name */
    private GameTagFlowLayout f212936q1;

    /* renamed from: r1, reason: collision with root package name */
    private final s.b f212937r1;

    /* renamed from: s1, reason: collision with root package name */
    private boolean f212938s1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.gamecenter.qa.view.QQGameStrategyQuestionControl$2, reason: invalid class name */
    /* loaded from: classes12.dex */
    public class AnonymousClass2 extends fe1.a {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            QQGameStrategyQuestionControl.this.C3(true);
        }

        @Override // fe1.a, fe1.d
        public void onChannelPublishQuestionFinish(long j3, long j16, String str, int i3) {
            super.onChannelPublishQuestionFinish(j3, j16, str, i3);
            QLog.d("QQGameStrategyQuestionFragment", 1, "onChannelPublishQuestionFinish errorCode:", Long.valueOf(j3), ",questionId:", Long.valueOf(j16), ",random:", Integer.valueOf(i3), ",arkJson:", str);
            QQGameStrategyQuestionControl.this.u3(j3, j16, 0);
        }

        @Override // fe1.a, fe1.d
        public void onGetInviteList(long j3, List<String> list) {
            super.onGetInviteList(j3, list);
            QQGameStrategyQuestionControl.this.e3(j3, list);
        }

        @Override // fe1.a, fe1.d
        public void onGetInviteListDetail(long j3, List<InviteData> list) {
            super.onGetInviteListDetail(j3, list);
            if (list != null && !list.isEmpty()) {
                QQGameStrategyQuestionControl.this.f212932m1.clear();
                QQGameStrategyQuestionControl.this.f212932m1.addAll(list);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.bq
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQGameStrategyQuestionControl.AnonymousClass2.this.b();
                    }
                });
            }
        }

        @Override // fe1.a, fe1.d
        public void onInviteUser(long j3, List<Long> list) {
            int i3;
            super.onInviteUser(j3, list);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onInviteUser errorCode:");
            sb5.append(j3);
            sb5.append(",list:");
            if (list != null) {
                i3 = list.size();
            } else {
                i3 = 0;
            }
            sb5.append(i3);
            QLog.i("QQGameStrategyQuestionFragment", 1, sb5.toString());
        }

        @Override // fe1.a, fe1.d
        public void onPublishQuestionFinish(long j3, long j16, int i3) {
            super.onPublishQuestionFinish(j3, j16, i3);
            QQGameStrategyQuestionControl.this.u3(j3, j16, i3);
        }

        @Override // fe1.a, fe1.d
        public void onQueryTagsFinish(long j3, final List<GameStrategyTag> list) {
            super.onQueryTagsFinish(j3, list);
            QQGameStrategyQuestionControl.this.t3(list);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.QQGameStrategyQuestionControl.2.2
                @Override // java.lang.Runnable
                public void run() {
                    QQGameStrategyQuestionControl.this.B3(list);
                }
            });
        }

        @Override // fe1.a, fe1.d
        public void onSearchQuestionsFinish(long j3, final List<com.tencent.mobileqq.gamecenter.qa.model.j> list) {
            super.onSearchQuestionsFinish(j3, list);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.QQGameStrategyQuestionControl.2.1
                @Override // java.lang.Runnable
                public void run() {
                    QQGameStrategyQuestionControl.this.D3(list, true, true);
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements bk.b {
        b() {
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.bk.b
        public void a(com.tencent.mobileqq.gamecenter.qa.model.j jVar) {
            GameQAUtil.z(QQGameStrategyQuestionControl.this.A0(), jVar.f212663a, jVar.f212664b);
            QQGameStrategyQuestionControl qQGameStrategyQuestionControl = QQGameStrategyQuestionControl.this;
            if (qQGameStrategyQuestionControl.J == 0) {
                com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102528", "209604", "20", String.valueOf(qQGameStrategyQuestionControl.f212920a1.f212658a), null);
            } else {
                com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907123", "8", String.valueOf(qQGameStrategyQuestionControl.f212920a1.f212658a), GameQAUtil.j(QQGameStrategyQuestionControl.this.A0(), QQGameStrategyQuestionControl.this.f212920a1.f212662e, jVar.f212664b));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements bj.b {
        c() {
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.bj.b
        @SuppressLint({"NotifyDataSetChanged"})
        public void a(GameStrategyTag gameStrategyTag) {
            if (!gameStrategyTag.isSelected) {
                QQGameStrategyQuestionControl qQGameStrategyQuestionControl = QQGameStrategyQuestionControl.this;
                if (qQGameStrategyQuestionControl.J == 0) {
                    com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102528", "209603", "20", String.valueOf(qQGameStrategyQuestionControl.f212920a1.f212658a), null);
                }
                if (QQGameStrategyQuestionControl.this.l3()) {
                    QQToast.makeText(QQGameStrategyQuestionControl.this.I, 1, String.format(Locale.getDefault(), QQGameStrategyQuestionControl.this.I.getResources().getString(R.string.f1372706e), 3), 0).show();
                    return;
                }
            }
            gameStrategyTag.isSelected = !gameStrategyTag.isSelected;
            QQGameStrategyQuestionControl.this.f212924e1.notifyDataSetChanged();
            QQGameStrategyQuestionControl.this.E3();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class d implements TextView.OnEditorActionListener {
        d() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            boolean z16 = false;
            if (keyEvent != null && keyEvent.getKeyCode() == 66) {
                z16 = true;
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class e implements View.OnFocusChangeListener {
        e() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            if (z16) {
                QQGameStrategyQuestionControl.this.D3(null, false, true);
            } else {
                QQGameStrategyQuestionControl.this.D3(null, false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class f implements a.InterfaceC11539a {

        /* renamed from: a, reason: collision with root package name */
        private int f212950a;

        /* renamed from: b, reason: collision with root package name */
        private int f212951b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f212952c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f212953d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f212954e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f212955f;

        f(List list, List list2, List list3, List list4) {
            this.f212952c = list;
            this.f212953d = list2;
            this.f212954e = list3;
            this.f212955f = list4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(GameStrategyImageSpan gameStrategyImageSpan, int i3) {
            if (i3 == 3) {
                QQGameStrategyQuestionControl.this.r2(gameStrategyImageSpan);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(GameStrategyImageSpan gameStrategyImageSpan, int i3) {
            if (i3 == 2) {
                QQGameStrategyQuestionControl.this.u0(gameStrategyImageSpan);
            }
        }

        @Override // xd1.a.InterfaceC11539a
        public void a(SpannableStringBuilder spannableStringBuilder, yd1.b bVar) {
            this.f212950a = spannableStringBuilder.length();
            int i3 = bVar.f450173d.f450176a;
            if (i3 == 2 || i3 == 1) {
                spannableStringBuilder.append("\u200b");
            }
        }

        @Override // xd1.a.InterfaceC11539a
        public void b(SpannableStringBuilder spannableStringBuilder, yd1.b bVar) {
            this.f212951b = spannableStringBuilder.length();
            int i3 = bVar.f450173d.f450176a;
            if (i3 == 1) {
                spannableStringBuilder.setSpan(new zd1.b(ae1.a.c(), bVar.f450173d.f450178c), this.f212950a, this.f212951b, 33);
            } else if (i3 == 2) {
                int c16 = ae1.a.c();
                b.C11604b c11604b = bVar.f450173d;
                spannableStringBuilder.setSpan(new zd1.c(c11604b.f450177b, c16, c11604b.f450178c), this.f212950a, this.f212951b, 33);
            }
            if ("left".equals(bVar.f450173d.f450179d)) {
                spannableStringBuilder.setSpan(new AlignmentSpan(Layout.Alignment.ALIGN_NORMAL, false), this.f212950a, this.f212951b, 33);
            } else if ("center".equals(bVar.f450173d.f450179d)) {
                spannableStringBuilder.setSpan(new AlignmentSpan(Layout.Alignment.ALIGN_CENTER, false), this.f212950a, this.f212951b, 33);
            } else if ("right".equals(bVar.f450173d.f450179d)) {
                spannableStringBuilder.setSpan(new AlignmentSpan(Layout.Alignment.ALIGN_OPPOSITE, false), this.f212950a, this.f212951b, 33);
            }
            int i16 = bVar.f450173d.f450180e;
            if (i16 != 0) {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(ViewUtils.spToPx(i16)), this.f212950a, this.f212951b, 33);
            }
            spannableStringBuilder.append("\n");
        }

        @Override // xd1.a.InterfaceC11539a
        public void c(SpannableStringBuilder spannableStringBuilder, c.C11605c c11605c) {
            if (c11605c != null) {
                List<GameStrategyVideo> videos = QQGameStrategyQuestionControl.this.f212928i1.getVideos();
                int i3 = c11605c.f450192c;
                if (i3 >= 0 && i3 < videos.size()) {
                    GameStrategyVideo gameStrategyVideo = videos.get(c11605c.f450192c);
                    if (gameStrategyVideo.isValid()) {
                        final GameStrategyImageSpan e16 = GameStrategyImageSpan.e(gameStrategyVideo.mCoverUrl, (int) (((float) com.tencent.mobileqq.utils.ah.M()) - (com.tencent.mobileqq.utils.ah.f307408i * 52.0f)), gameStrategyVideo.mLocalPath, gameStrategyVideo.mVideoUrl, gameStrategyVideo.mCoverWidth, gameStrategyVideo.mCoverHeight);
                        e16.H(gameStrategyVideo.mDuration);
                        e16.I(gameStrategyVideo.mVideoUrl);
                        e16.C(new GameStrategyImageSpan.a() { // from class: com.tencent.mobileqq.gamecenter.qa.view.br
                            @Override // com.tencent.mobileqq.gamecenter.qa.view.GameStrategyImageSpan.a
                            public final void onClick(int i16) {
                                QQGameStrategyQuestionControl.f.this.k(e16, i16);
                            }
                        });
                        String n3 = e16.n(false);
                        int length = spannableStringBuilder.length();
                        int length2 = n3.length() + length;
                        spannableStringBuilder.append((CharSequence) n3);
                        spannableStringBuilder.append("\n");
                        spannableStringBuilder.setSpan(e16, length, length2, 33);
                        this.f212953d.add(e16);
                        return;
                    }
                    return;
                }
                QLog.e("QQGameStrategyQuestionFragment", 1, "onParseVideo, videoBlock index invalid=", Integer.valueOf(c11605c.f450192c));
            }
        }

        @Override // xd1.a.InterfaceC11539a
        public void d(SpannableStringBuilder spannableStringBuilder, yd1.b bVar, b.d dVar) {
            if (dVar != null && !TextUtils.isEmpty(dVar.f450182b)) {
                String str = dVar.f450182b;
                int length = spannableStringBuilder.length();
                int length2 = str.length() + length;
                spannableStringBuilder.append((CharSequence) str);
                if (dVar.f450183c) {
                    spannableStringBuilder.setSpan(new BoldSpan(), length, length2, 33);
                }
                if (dVar.f450185e) {
                    spannableStringBuilder.setSpan(new ItalicSpan(), length, length2, 33);
                }
                if (dVar.f450184d) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), length, length2, 33);
                }
            }
        }

        @Override // xd1.a.InterfaceC11539a
        public void e(SpannableStringBuilder spannableStringBuilder, c.b bVar) {
            String str;
            if (bVar != null) {
                try {
                    String str2 = null;
                    if (!TextUtils.isEmpty(bVar.f450191e)) {
                        str = URLDecoder.decode(bVar.f450191e, "UTF-8");
                    } else {
                        str = null;
                    }
                    if (!TextUtils.isEmpty(bVar.f450190d)) {
                        str2 = URLDecoder.decode(bVar.f450190d, "UTF-8");
                    }
                    ab l3 = ab.l(str2, str, QQGameStrategyQuestionControl.this.f213074y0);
                    String k3 = com.tencent.mobileqq.gamecenter.qa.manager.b.k(str, str2);
                    int length = spannableStringBuilder.length();
                    int length2 = k3.length() + length;
                    spannableStringBuilder.append((CharSequence) k3);
                    spannableStringBuilder.setSpan(l3, length, length2, 33);
                    this.f212954e.add(l3);
                    return;
                } catch (UnsupportedEncodingException e16) {
                    QLog.e("QQGameStrategyQuestionFragment", 1, "onParseRef, exception=", e16);
                    return;
                }
            }
            QLog.e("QQGameStrategyQuestionFragment", 1, "onParseRef, refBlock index invalid refBlock null");
        }

        @Override // xd1.a.InterfaceC11539a
        public void f(SpannableStringBuilder spannableStringBuilder, yd1.b bVar, b.a aVar) {
            String str;
            if (aVar != null) {
                try {
                    String str2 = null;
                    if (!TextUtils.isEmpty(aVar.f450182b)) {
                        str = URLDecoder.decode(aVar.f450182b, "UTF-8");
                    } else {
                        str = null;
                    }
                    if (!TextUtils.isEmpty(aVar.f450174f)) {
                        str2 = URLDecoder.decode(aVar.f450174f, "UTF-8");
                    }
                    ab l3 = ab.l(str2, str, QQGameStrategyQuestionControl.this.f213074y0);
                    String k3 = com.tencent.mobileqq.gamecenter.qa.manager.b.k(str, str2);
                    int length = spannableStringBuilder.length();
                    int length2 = k3.length() + length;
                    spannableStringBuilder.append((CharSequence) k3);
                    spannableStringBuilder.setSpan(l3, length, length2, 33);
                    this.f212955f.add(l3);
                } catch (UnsupportedEncodingException e16) {
                    QLog.e("QQGameStrategyQuestionFragment", 1, "onParseLinkSection, exception=", e16);
                }
            }
        }

        @Override // xd1.a.InterfaceC11539a
        public void g(SpannableStringBuilder spannableStringBuilder, c.a aVar) {
            if (aVar != null) {
                List<GameStrategyPic> pics = QQGameStrategyQuestionControl.this.f212928i1.getPics();
                int i3 = aVar.f450188c;
                if (i3 >= 0 && i3 < pics.size()) {
                    GameStrategyPic gameStrategyPic = pics.get(aVar.f450188c);
                    if (gameStrategyPic.isCoverValid()) {
                        final GameStrategyImageSpan d16 = GameStrategyImageSpan.d(QQGameStrategyQuestionControl.this.E0(), (int) (((float) com.tencent.mobileqq.utils.ah.M()) - (com.tencent.mobileqq.utils.ah.f307408i * 52.0f)), gameStrategyPic.mLocalPath, gameStrategyPic.mUrl, gameStrategyPic.mWidth, gameStrategyPic.mHeight);
                        d16.C(new GameStrategyImageSpan.a() { // from class: com.tencent.mobileqq.gamecenter.qa.view.bs
                            @Override // com.tencent.mobileqq.gamecenter.qa.view.GameStrategyImageSpan.a
                            public final void onClick(int i16) {
                                QQGameStrategyQuestionControl.f.this.j(d16, i16);
                            }
                        });
                        String n3 = d16.n(false);
                        int length = spannableStringBuilder.length();
                        int length2 = n3.length() + length;
                        spannableStringBuilder.append((CharSequence) n3);
                        spannableStringBuilder.append("\n");
                        spannableStringBuilder.setSpan(d16, length, length2, 33);
                        this.f212952c.add(d16);
                        return;
                    }
                    return;
                }
                QLog.e("QQGameStrategyQuestionFragment", 1, "onParsePic, picBlock index invalid=", Integer.valueOf(aVar.f450188c));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class g extends b.AbstractC7648b {
        g() {
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.s.b
        public void a(@Nullable String str, @Nullable String str2, @Nullable ab abVar) {
            QQGameStrategyQuestionControl qQGameStrategyQuestionControl = QQGameStrategyQuestionControl.this;
            if (qQGameStrategyQuestionControl.J == 0) {
                com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102528", "907466", "20", String.valueOf(qQGameStrategyQuestionControl.f212920a1.f212658a), null);
            }
        }
    }

    public QQGameStrategyQuestionControl(Activity activity, Context context, com.tencent.mobileqq.gamecenter.qa.model.i iVar, int i3, boolean z16) {
        super(activity, context, i3, z16);
        this.f212921b1 = new fe1.c();
        this.f212925f1 = new ArrayList();
        this.f212926g1 = new ArrayList();
        this.f212927h1 = true;
        this.f212929j1 = new AtomicBoolean();
        this.f212932m1 = new ArrayList<>();
        this.f212933n1 = new ArrayList<>();
        this.f212934o1 = new a();
        this.f212935p1 = new AnonymousClass2();
        this.f212937r1 = new g();
        this.f212920a1 = iVar;
        this.f212922c1 = new GameStrategyDraftHandler(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A3() {
        QQToast.makeText(BaseApplication.getContext(), R.string.f1372206_, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B3(List<GameStrategyTag> list) {
        GameTagFlowLayout gameTagFlowLayout;
        if (list != null && list.size() > 0) {
            this.f212925f1 = list;
            this.Z0.setVisibility(0);
            this.L.setVisibility(0);
            E3();
            if (this.J0 && (gameTagFlowLayout = this.f212936q1) != null) {
                gameTagFlowLayout.setTagList(this.f212925f1);
                return;
            } else {
                this.f212924e1.setData(this.f212925f1);
                return;
            }
        }
        this.Z0.setVisibility(8);
        this.L.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C3(boolean z16) {
        if (!z16) {
            this.F.setVisibility(8);
        } else {
            this.F.setVisibility(0);
            int color = this.I.getResources().getColor(R.color.f157842cg4);
            int color2 = this.I.getResources().getColor(R.color.f157838cg0);
            ImageView imageView = this.E;
            if (!this.K) {
                color = color2;
            }
            imageView.setColorFilter(color);
        }
        Z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D3(List<com.tencent.mobileqq.gamecenter.qa.model.j> list, boolean z16, boolean z17) {
        if (!z16) {
            if (z17 && this.f212923d1.k0()) {
                this.X0.setVisibility(0);
                return;
            } else {
                this.X0.setVisibility(8);
                return;
            }
        }
        if (list != null && list.size() != 0 && this.P0.getEditableText().length() != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < list.size() && i3 < 2; i3++) {
                arrayList.add(list.get(i3));
            }
            this.X0.setVisibility(0);
            this.f212923d1.setData(arrayList);
            if (this.J == 0) {
                com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102528", "209605", "5", String.valueOf(this.f212920a1.f212658a), null);
                return;
            } else {
                com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907124", "8", String.valueOf(this.f212920a1.f212658a), GameQAUtil.i(A0(), this.f212920a1.f212662e));
                return;
            }
        }
        this.X0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E3() {
        this.f212931l1.setText(String.format(Locale.getDefault(), this.I.getResources().getString(R.string.f1372606d), Integer.valueOf(d3().size()), 3));
    }

    private void b3(boolean z16) {
        if (this.Q0.getVisibility() == 8) {
            return;
        }
        this.f213056i.setFocusableInTouchMode(true);
        if (z16) {
            this.f213056i.requestFocus();
        }
        this.Q0.setVisibility(8);
    }

    @NonNull
    private GameStrategyQuestion c3() {
        String str;
        Editable editableText = this.f213056i.getEditableText();
        GameStrategyQuestion gameStrategyQuestion = new GameStrategyQuestion();
        gameStrategyQuestion.mAppId = this.f212920a1.f212658a;
        if (this.P0.getText() != null) {
            str = this.P0.getText().toString();
        } else {
            str = "";
        }
        gameStrategyQuestion.mTitle = str;
        bh.w I0 = I0(editableText);
        if (I0 != null) {
            gameStrategyQuestion.addPics(I0.f213109a);
            gameStrategyQuestion.addVideos(I0.f213110b);
            gameStrategyQuestion.addLinkCards(I0.f213111c);
            gameStrategyQuestion.mContent = I0.f213112d;
            yd1.d a16 = new xd1.b().a((SpannableStringBuilder) editableText);
            gameStrategyQuestion.mRichContent = a16.serialize().toString();
            if (QLog.isColorLevel()) {
                QLog.d("QQGameStrategyQuestionFragment", 2, "richText:", a16, " mRichContent:", gameStrategyQuestion.mRichContent);
            }
        }
        gameStrategyQuestion.addTags(d3());
        return gameStrategyQuestion;
    }

    @NonNull
    private List<GameStrategyTag> d3() {
        ArrayList arrayList = new ArrayList();
        for (GameStrategyTag gameStrategyTag : this.f212925f1) {
            if (gameStrategyTag.isSelected) {
                arrayList.add(gameStrategyTag);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e3(long j3, List<String> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (list.isEmpty() && this.f212933n1.isEmpty()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.bn
                @Override // java.lang.Runnable
                public final void run() {
                    QQGameStrategyQuestionControl.this.p3();
                }
            });
        } else {
            for (int size = this.f212933n1.size() - 1; size >= 0; size--) {
                String str = this.f212933n1.get(size);
                if (!list.contains(str)) {
                    list.add(0, str);
                }
            }
            this.f212921b1.Q(2, this.f212920a1.f212658a, list);
        }
        QLog.i("QQGameStrategyQuestionFragment", 1, "onGetInviteList size:" + list.size() + ",errorCode:" + j3);
    }

    private void f3() {
        JSONArray optJSONArray;
        C3(false);
        if (this.J == 0) {
            try {
                if (!TextUtils.isEmpty(this.f212920a1.f212660c) && (optJSONArray = new JSONObject(this.f212920a1.f212660c).optJSONArray("invite_user_encoded_uins")) != null) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        this.f212933n1.clear();
                        this.f212933n1.add(optJSONArray.getString(i3));
                    }
                }
            } catch (Exception e16) {
                QLog.e("QQGameStrategyQuestionFragment", 1, e16, new Object[0]);
            }
            v3(this.f212920a1.f212658a);
        }
    }

    private void g3() {
        SimpleEventBus.getInstance().registerReceiver(this);
        this.f212921b1.Z0(this.f212935p1);
        this.f212921b1.W0(this.f212920a1.f212658a);
        i3();
        f3();
        w3();
        if (this.J == 0) {
            com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102528", "209599", "7", String.valueOf(this.f212920a1.f212658a), null);
        } else {
            com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907118", "8", String.valueOf(this.f212920a1.f212658a), GameQAUtil.i(A0(), this.f212920a1.f212662e));
        }
    }

    private void h3() {
        this.Q0.setVisibility(0);
        this.f213056i.setFocusableInTouchMode(false);
    }

    private void i3() {
        if (this.J == 0) {
            try {
                if (!TextUtils.isEmpty(this.f212920a1.f212660c)) {
                    String optString = new JSONObject(this.f212920a1.f212660c).optString("question_title");
                    if (!TextUtils.isEmpty(optString)) {
                        this.P0.setText(optString);
                    }
                }
            } catch (Exception e16) {
                QLog.e("QQGameStrategyQuestionFragment", 1, e16, new Object[0]);
            }
        }
    }

    private boolean j3() {
        String trim = this.f213056i.getEditableText().toString().trim();
        if (QLog.isColorLevel()) {
            QLog.i("QQGameStrategyQuestionFragment", 2, "isContentEditEmpty content=" + trim);
        }
        if (trim.length() == 0) {
            return true;
        }
        return "\n".equals(trim);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k3(String str) {
        if (str.trim().length() > 0 && str.length() >= 5) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l3() {
        if (d3().size() >= 3) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n3(GameStrategyTag gameStrategyTag) {
        if (!gameStrategyTag.isSelected) {
            if (this.J == 0) {
                com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102528", "209603", "20", String.valueOf(this.f212920a1.f212658a), null);
            }
            if (l3()) {
                QQToast.makeText(this.I, 1, String.format(Locale.getDefault(), this.I.getResources().getString(R.string.f1372706e), 3), 0).show();
                return;
            }
        }
        gameStrategyTag.isSelected = !gameStrategyTag.isSelected;
        E3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o3(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        d0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p3() {
        C3(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r3(long j3) {
        GameStrategyQuestion c36 = c3();
        c36.questionId = j3;
        GameStrategyDraftHandler gameStrategyDraftHandler = this.f212922c1;
        if (gameStrategyDraftHandler != null) {
            gameStrategyDraftHandler.u(c36);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s3(EditText editText) {
        editText.requestFocus();
        InputMethodUtil.show(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t3(List<GameStrategyTag> list) {
        for (GameStrategyTag gameStrategyTag : this.f212926g1) {
            for (GameStrategyTag gameStrategyTag2 : list) {
                if (gameStrategyTag2.mTagId == gameStrategyTag.mTagId) {
                    gameStrategyTag2.isSelected = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u3(long j3, final long j16, int i3) {
        int i16;
        int i17 = 0;
        QLog.d("QQGameStrategyQuestionFragment", 2, "questionFinish errorCode=", Long.valueOf(j3), ", questionId=", Long.valueOf(j16));
        this.H.removeMessages(256);
        this.H.removeMessages(255);
        this.H.sendEmptyMessage(255);
        if (j3 == 0) {
            if (i3 == 1) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.bl
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQGameStrategyQuestionControl.this.r3(j16);
                    }
                });
            } else {
                this.f212922c1.e(this.f212920a1.f212658a);
                this.f212921b1.J0(j16, this.f212920a1.f212658a, this.f212933n1);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.QQGameStrategyQuestionControl.9
                    @Override // java.lang.Runnable
                    public void run() {
                        GameQAUtil.A(BaseApplication.getContext(), QQGameStrategyQuestionControl.this.f212920a1.f212658a, j16, true, false, QQGameStrategyQuestionControl.this.f212933n1.size());
                        QQGameStrategyQuestionControl.this.j0(false);
                    }
                });
            }
        } else {
            Activity A0 = A0();
            if (i3 == 1) {
                i16 = R.string.f1372506c;
            } else {
                i16 = R.string.f13716064;
            }
            GameQAUtil.K(A0, false, i16);
        }
        if (this.J == 0) {
            if (j3 != 0) {
                i17 = -3;
            } else if (i3 == 1) {
                i17 = -5;
            }
            int i18 = i17;
            ((IGameQAIpcApi) QRoute.api(IGameQAIpcApi.class)).callbackStrategyQuestion(i18, this.f212920a1.f212658a, j16);
            com.tencent.mobileqq.gamecenter.qa.kuikly.a.INSTANCE.b(A0(), i18, this.f212920a1.f212658a, j16);
        }
    }

    private void v3(int i3) {
        this.f212921b1.P(1, i3, 0L, "");
        QLog.d("QQGameStrategyQuestionFragment", 2, "[getInviteList] appId:" + i3);
    }

    private void w3() {
        com.tencent.mobileqq.gamecenter.qa.model.i iVar = this.f212920a1;
        if (iVar.f212661d == 1) {
            this.f212928i1 = this.f212922c1.o(iVar.f212658a, iVar.f212660c);
        } else {
            this.f212928i1 = this.f212922c1.k(iVar.f212658a);
        }
        GameStrategyQuestion gameStrategyQuestion = this.f212928i1;
        if (gameStrategyQuestion != null && !TextUtils.isEmpty(gameStrategyQuestion.mRichContent)) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            SpannableStringBuilder a16 = new xd1.a().a(yd1.d.d(this.f212928i1.mRichContent), new f(arrayList3, arrayList4, arrayList2, arrayList));
            this.P0.setText(this.f212928i1.mTitle);
            EditText editText = this.P0;
            editText.setSelection(editText.getEditableText().length());
            this.f213056i.X();
            this.f213056i.setText(a16);
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                ((GameStrategyImageSpan) it.next()).L(this.f213056i);
            }
            Iterator it5 = arrayList4.iterator();
            while (it5.hasNext()) {
                ((GameStrategyImageSpan) it5.next()).L(this.f213056i);
            }
            this.f213047d.t(A0(), this.f213056i, this.f213074y0, arrayList, this.K, this.f212937r1);
            this.f213047d.t(A0(), this.f213056i, this.f213074y0, arrayList2, this.K, this.f212937r1);
            Iterator it6 = arrayList2.iterator();
            while (it6.hasNext()) {
                ((ab) it6.next()).B(A0(), null, "");
            }
            GameStrategyEditTextView gameStrategyEditTextView = this.f213056i;
            gameStrategyEditTextView.setSelection(gameStrategyEditTextView.getEditableText().length());
            this.f213056i.e0();
            this.f212926g1 = this.f212928i1.getTags();
            if (!TextUtils.isEmpty(this.f212928i1.mContent)) {
                b3(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x3(String str) {
        this.f212921b1.X0(this.f212920a1.f212658a, str);
    }

    private boolean y3(boolean z16) {
        int color;
        boolean z17 = !k3(this.P0.getEditableText().toString());
        if (z16 && z17) {
            this.V0.setVisibility(0);
            this.V0.setTextColor(SupportMenu.CATEGORY_MASK);
        } else if (this.V0.getVisibility() == 0) {
            TextView textView = this.V0;
            if (this.K) {
                color = E0().getResources().getColor(R.color.cg_);
            } else {
                color = E0().getResources().getColor(R.color.cg9);
            }
            textView.setTextColor(color);
        }
        return z17;
    }

    private void z3() {
        final EditText editText;
        if (this.P0.isFocused()) {
            editText = this.P0;
        } else {
            editText = this.f213056i;
        }
        editText.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.bm
            @Override // java.lang.Runnable
            public final void run() {
                QQGameStrategyQuestionControl.s3(editText);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public int B0() {
        com.tencent.mobileqq.gamecenter.qa.model.i iVar = this.f212920a1;
        if (iVar != null) {
            return iVar.f212658a;
        }
        return super.B0();
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    protected int D0() {
        return R.layout.ec7;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    protected File F0() {
        return GameStrategyDraftHandler.p(this.f212920a1.f212658a);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    protected EditText G0() {
        if (this.P0.isFocused()) {
            return this.P0;
        }
        return this.f213056i;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public s.b H0() {
        return this.f212937r1;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    protected void J1() {
        com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102528", "912822", "20", String.valueOf(this.f212920a1.f212658a), null);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    protected void K1() {
        com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102528", "912821", "8", String.valueOf(this.f212920a1.f212658a), null);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    protected String L0() {
        return E0().getResources().getString(R.string.f13719067);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    protected void Q0(GameQALinkCardData gameQALinkCardData) {
        if (gameQALinkCardData != null) {
            this.f213047d.m(A0(), G0(), gameQALinkCardData, this.f213074y0, this.K, this.f212937r1);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    protected void R1(boolean z16) {
        String str;
        b3(true);
        HashMap hashMap = new HashMap();
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put(2, str);
        com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102528", "912954", "20", String.valueOf(this.f212920a1.f212658a), hashMap);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    protected void S1(int i3, boolean z16) {
        String str;
        HashMap hashMap = new HashMap();
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put(2, str);
        com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102528", "912955", "20", String.valueOf(this.f212920a1.f212658a), hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public void W1() {
        long j3;
        super.W1();
        if (y3(true)) {
            return;
        }
        if (!c1()) {
            QQToast.makeText(A0(), R.string.f1370405s, 0).show();
            return;
        }
        GameStrategyQuestion c36 = c3();
        this.H.removeMessages(256);
        this.H.sendEmptyMessageDelayed(256, 500L);
        if (this.J == 1) {
            c36.channelEntry = this.f212920a1.f212662e;
            this.f212921b1.R0(c36);
        } else {
            fe1.c cVar = this.f212921b1;
            GameStrategyQuestion gameStrategyQuestion = this.f212928i1;
            if (gameStrategyQuestion != null) {
                j3 = gameStrategyQuestion.questionId;
            } else {
                j3 = 0;
            }
            cVar.T0(c36, j3);
        }
        if (this.J == 0) {
            com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102528", "209606", "20", String.valueOf(this.f212920a1.f212658a), null);
        } else {
            com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907125", "20", String.valueOf(this.f212920a1.f212658a), GameQAUtil.i(A0(), this.f212920a1.f212662e));
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public void X1() {
        long j3;
        super.X1();
        if (!c1()) {
            QQToast.makeText(A0(), R.string.f1370405s, 0).show();
            return;
        }
        GameStrategyQuestion gameStrategyQuestion = this.f212928i1;
        if (gameStrategyQuestion != null) {
            j3 = gameStrategyQuestion.questionId;
        } else {
            j3 = 0;
        }
        if (this.J == 0) {
            GameStrategyQuestion c36 = c3();
            this.H.removeMessages(256);
            this.H.sendEmptyMessageDelayed(256, 500L);
            this.f212921b1.V0(c36, j3);
            com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102528", "209889", "20", String.valueOf(this.f212920a1.f212658a), null);
            return;
        }
        GameStrategyQuestion c37 = c3();
        c37.questionId = j3;
        this.f212922c1.u(c37);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public void Z0() {
        super.Z0();
        if (this.J == 0) {
            com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102528", "209602", "20", String.valueOf(this.f212920a1.f212658a), null);
        } else {
            com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907120", "20", String.valueOf(this.f212920a1.f212658a), GameQAUtil.i(A0(), this.f212920a1.f212662e));
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    protected void b0(String str) {
        if (this.f213074y0 && this.f213047d != null) {
            Editable editableText = this.f213056i.getEditableText();
            int lastIndexOf = editableText.toString().lastIndexOf(str);
            editableText.delete(lastIndexOf, str.length() + lastIndexOf);
            this.f213047d.n(A0(), G0(), str, this.f213074y0, this.K, this.f212937r1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public void d0() {
        super.d0();
        ((IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class)).openGameStrategyAtDialog((QBaseActivity) A0(), this.f212920a1.f212658a, 0L, new ArrayList<>(this.f212932m1), new ArrayList<>(this.f212933n1));
        if (this.J == 0) {
            HashMap hashMap = new HashMap();
            hashMap.put(2, "1");
            com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102528", "908077", "20", String.valueOf(this.f212920a1.f212658a), hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public void e0() {
        b3(true);
        super.e0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public void f0() {
        super.f0();
        this.f212938s1 = true;
        if (this.J == 0) {
            com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102528", "209898", "20", String.valueOf(this.f212920a1.f212658a), null);
        } else {
            com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907121", "20", String.valueOf(this.f212920a1.f212658a), GameQAUtil.i(A0(), this.f212920a1.f212662e));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public void g0() {
        super.g0();
        this.f212938s1 = true;
        this.f213047d.l(A0(), G0(), this.f213074y0, this.K, this.f212937r1);
        com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102528", "912820", "20", String.valueOf(this.f212920a1.f212658a), null);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QASelectExpertsEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh, android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        int i3 = message.what;
        return super.handleMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public void i0() {
        super.i0();
        this.f212938s1 = true;
        if (this.J == 0) {
            com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102528", "907213", "20", String.valueOf(this.f212920a1.f212658a), null);
        } else {
            com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907435", "20", String.valueOf(this.f212920a1.f212658a), GameQAUtil.i(A0(), this.f212920a1.f212662e));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public boolean k0() {
        if (this.P0.getEditableText().length() <= 0 && j3()) {
            GameQAUtil.w(A0().getIntent().getIntExtra("miniGameAppId", 0));
            return false;
        }
        com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102528", "209888", "8", String.valueOf(this.f212920a1.f212658a), null);
        return super.k0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f88784y0 || id5 == R.id.f89044yp) {
            b3(true);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QASelectExpertsEvent) {
            this.f212933n1.clear();
            this.f212933n1.addAll(((QASelectExpertsEvent) simpleBaseEvent).selectedUinList);
            C3(true);
            QLog.i("QQGameStrategyQuestionFragment", 1, "[onReceiveEvent] mExpertListSize:" + this.f212932m1.size());
            if (this.J == 0) {
                HashMap hashMap = new HashMap();
                hashMap.put(2, "1");
                com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "916601", "908051", "20", String.valueOf(this.f212920a1.f212658a), hashMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public void p0(LayoutInflater layoutInflater, @android.support.annotation.Nullable ViewGroup viewGroup, @android.support.annotation.Nullable Bundle bundle) {
        super.p0(layoutInflater, viewGroup, bundle);
        this.f213051f = -1;
        j2(R.string.f13718066, true);
        this.Q0 = (LinearLayout) this.C.findViewById(R.id.f89034yo);
        this.R0 = (TextView) this.C.findViewById(R.id.f89074ys);
        this.S0 = (TextView) this.C.findViewById(R.id.f89054yq);
        this.T0 = (ImageView) this.C.findViewById(R.id.f89064yr);
        ImageView imageView = (ImageView) this.C.findViewById(R.id.f89044yp);
        this.U0 = imageView;
        imageView.setOnClickListener(this);
        EditText editText = (EditText) this.f213054h.findViewById(R.id.f88954yg);
        this.P0 = editText;
        int i3 = 0;
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
        this.V0 = (TextView) this.f213054h.findViewById(R.id.f88944yf);
        this.W0 = (TextView) this.f213054h.findViewById(R.id.f88934ye);
        this.Y0 = (RecyclerView) this.D.findViewById(R.id.f88984yj);
        this.Z0 = this.D.findViewById(R.id.f89004yl);
        RecyclerView recyclerView = (RecyclerView) this.C.findViewById(R.id.f88964yh);
        this.X0 = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(E0(), 1, false));
        bk bkVar = new bk();
        this.f212923d1 = bkVar;
        bkVar.o0(this.K);
        this.X0.setAdapter(this.f212923d1);
        this.X0.bringToFront();
        this.f212923d1.n0(new b());
        this.L = (LinearLayout) this.D.findViewById(R.id.f88994yk);
        this.f212931l1 = (TextView) this.D.findViewById(R.id.f89014ym);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(E0());
        linearLayoutManager.setOrientation(0);
        this.Y0.setLayoutManager(linearLayoutManager);
        bj bjVar = new bj();
        this.f212924e1 = bjVar;
        bjVar.m0(this.K);
        this.Y0.setAdapter(this.f212924e1);
        this.f212924e1.l0(new c());
        if (this.J0) {
            this.Y0.setVisibility(8);
            GameTagFlowLayout gameTagFlowLayout = (GameTagFlowLayout) this.D.findViewById(R.id.f88974yi);
            this.f212936q1 = gameTagFlowLayout;
            gameTagFlowLayout.setNightTheme(this.K);
            this.f212936q1.setItemClickListener(new bj.b() { // from class: com.tencent.mobileqq.gamecenter.qa.view.bo
                @Override // com.tencent.mobileqq.gamecenter.qa.view.bj.b
                public final void a(GameStrategyTag gameStrategyTag) {
                    QQGameStrategyQuestionControl.this.n3(gameStrategyTag);
                }
            });
        }
        this.f213056i.setOnClickListener(this);
        this.P0.setFocusable(true);
        this.P0.setFocusableInTouchMode(true);
        this.P0.requestFocus();
        this.P0.addTextChangedListener(this.f212934o1);
        this.P0.setOnEditorActionListener(new d());
        this.P0.setOnFocusChangeListener(new e());
        this.f212930k1 = this.f213054h.findViewById(R.id.f89154z0);
        this.F.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.bp
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGameStrategyQuestionControl.this.o3(view);
            }
        });
        ViewGroup viewGroup2 = this.F;
        if (this.J != 0) {
            i3 = 8;
        }
        viewGroup2.setVisibility(i3);
        ((LinearLayout) this.D.findViewById(R.id.f2226039)).setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((LinearLayout) this.D.findViewById(R.id.f224503r)).getLayoutParams();
        layoutParams.removeRule(3);
        layoutParams.addRule(10);
        h3();
        g3();
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public void q0() {
        super.q0();
        this.f212921b1.N0();
        QQProgressDialog qQProgressDialog = this.G;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
        }
        this.H.removeCallbacksAndMessages(null);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public void s0(boolean z16, boolean z17) {
        super.s0(z16, z17);
        if (z16) {
            this.Q0.setBackgroundResource(R.drawable.jqt);
            this.X0.setBackgroundColor(this.I.getResources().getColor(R.color.cgh));
            this.P0.setHintTextColor(this.I.getResources().getColor(R.color.cgb));
            this.P0.setTextColor(this.I.getResources().getColor(R.color.cg8));
            this.R0.setTextColor(this.I.getResources().getColor(R.color.cgf));
            this.S0.setTextColor(this.I.getResources().getColor(R.color.cgd));
            this.T0.setImageResource(R.drawable.mx8);
            this.U0.setImageResource(R.drawable.mx_);
            this.f212930k1.setBackgroundResource(R.color.cfk);
            return;
        }
        if (!z17) {
            return;
        }
        this.Q0.setBackgroundResource(R.drawable.jqs);
        this.X0.setBackgroundColor(this.I.getResources().getColor(R.color.cgg));
        this.P0.setHintTextColor(this.I.getResources().getColor(R.color.cga));
        this.P0.setTextColor(this.I.getResources().getColor(R.color.cg7));
        this.R0.setTextColor(this.I.getResources().getColor(R.color.cge));
        this.S0.setTextColor(this.I.getResources().getColor(R.color.cgc));
        this.T0.setImageResource(R.drawable.mx7);
        this.U0.setImageResource(R.drawable.mx9);
        this.f212930k1.setBackgroundResource(R.color.cfj);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public void t0() {
        super.t0();
        if (!this.f212938s1) {
            z3();
        }
        this.f212938s1 = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public void v2(boolean z16, boolean z17) {
        int i3;
        super.v2(z16, z17);
        TextView textView = this.f212931l1;
        if (z17) {
            i3 = R.color.cfy;
        } else {
            i3 = R.color.black;
        }
        textView.setTextColor(com.tencent.mobileqq.gamecenter.qa.util.k.c(i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public void y0() {
        super.y0();
        if (this.J == 0) {
            com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102528", "209890", "20", String.valueOf(this.f212920a1.f212658a), null);
        }
        this.f212922c1.e(this.f212920a1.f212658a);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            QQGameStrategyQuestionControl.this.x3(editable.toString());
            if (editable.length() == 0) {
                QQGameStrategyQuestionControl.this.D3(null, true, false);
            }
            if (QQGameStrategyQuestionControl.this.f212927h1) {
                QQGameStrategyQuestionControl qQGameStrategyQuestionControl = QQGameStrategyQuestionControl.this;
                if (qQGameStrategyQuestionControl.J == 0) {
                    com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102528", "209601", "20", String.valueOf(qQGameStrategyQuestionControl.f212920a1.f212658a), null);
                } else {
                    com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907119", "20", String.valueOf(qQGameStrategyQuestionControl.f212920a1.f212658a), GameQAUtil.i(QQGameStrategyQuestionControl.this.A0(), QQGameStrategyQuestionControl.this.f212920a1.f212662e));
                }
                QQGameStrategyQuestionControl.this.f212927h1 = false;
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (QQGameStrategyQuestionControl.this.V0.getVisibility() != 8) {
                QQGameStrategyQuestionControl.this.V0.setVisibility(8);
            }
            if (QQGameStrategyQuestionControl.this.k3(charSequence.toString())) {
                int length = charSequence.length();
                if (length > 50 && !QQGameStrategyQuestionControl.this.f212929j1.getAndSet(true)) {
                    QQGameStrategyQuestionControl.this.A3();
                }
                if (length >= 1000) {
                    QQGameStrategyQuestionControl.this.W0.setVisibility(0);
                    QQGameStrategyQuestionControl.this.W0.setText(String.format(Locale.getDefault(), "%d/1000", Integer.valueOf(length)));
                    return;
                } else {
                    QQGameStrategyQuestionControl.this.W0.setVisibility(8);
                    return;
                }
            }
            QQGameStrategyQuestionControl.this.W0.setVisibility(8);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
