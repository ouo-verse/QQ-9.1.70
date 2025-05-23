package com.tencent.mobileqq.gamecenter.qa.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.qa.api.IGameQAIpcApi;
import com.tencent.mobileqq.gamecenter.qa.editor.span.AbsoluteSizeSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.span.AlignmentSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.span.BoldSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.span.ItalicSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.span.UnderlineSpan;
import com.tencent.mobileqq.gamecenter.qa.kuikly.a;
import com.tencent.mobileqq.gamecenter.qa.manager.GameStrategyDraftHandler;
import com.tencent.mobileqq.gamecenter.qa.manager.b;
import com.tencent.mobileqq.gamecenter.qa.model.GameQALinkCardData;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyAnswer;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyPic;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyVideo;
import com.tencent.mobileqq.gamecenter.qa.util.GameQAUtil;
import com.tencent.mobileqq.gamecenter.qa.view.GameStrategyImageSpan;
import com.tencent.mobileqq.gamecenter.qa.view.QQGameStrategyAnswerControl;
import com.tencent.mobileqq.gamecenter.qa.view.bh;
import com.tencent.mobileqq.gamecenter.qa.view.s;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import xd1.a;
import yd1.b;
import yd1.c;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGameStrategyAnswerControl extends bh {
    private TextView P0;
    private com.tencent.mobileqq.gamecenter.qa.model.h Q0;
    private fe1.c R0;
    private GameStrategyDraftHandler S0;
    private GameStrategyAnswer T0;
    private fe1.d U0;
    private final s.b V0;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends fe1.a {
        a() {
        }

        @Override // fe1.a, fe1.d
        public void onAnswerQuestionFinish(long j3, long j16, int i3) {
            super.onAnswerQuestionFinish(j3, j16, i3);
            QQGameStrategyAnswerControl.this.D2(j3, j16, i3);
        }

        @Override // fe1.a, fe1.d
        public void onChannelAnswerQuestionFinish(long j3, long j16, String str, int i3) {
            super.onChannelAnswerQuestionFinish(j3, j16, str, i3);
            QLog.d("QQGameStrategyBaseControl", 1, "onChannelAnswerQuestionFinish errorCode:", Long.valueOf(j3), ",answerId:", Long.valueOf(j16), ",random:", Integer.valueOf(i3), ",arkJson:", str);
            QQGameStrategyAnswerControl.this.D2(j3, j16, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements a.InterfaceC11539a {

        /* renamed from: a, reason: collision with root package name */
        private int f212912a;

        /* renamed from: b, reason: collision with root package name */
        private int f212913b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f212914c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f212915d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f212916e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f212917f;

        b(List list, List list2, List list3, List list4) {
            this.f212914c = list;
            this.f212915d = list2;
            this.f212916e = list3;
            this.f212917f = list4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(GameStrategyImageSpan gameStrategyImageSpan, int i3) {
            if (i3 == 3) {
                QQGameStrategyAnswerControl.this.r2(gameStrategyImageSpan);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(GameStrategyImageSpan gameStrategyImageSpan, int i3) {
            if (i3 == 2) {
                QQGameStrategyAnswerControl.this.u0(gameStrategyImageSpan);
            }
        }

        @Override // xd1.a.InterfaceC11539a
        public void a(SpannableStringBuilder spannableStringBuilder, yd1.b bVar) {
            this.f212912a = spannableStringBuilder.length();
            int i3 = bVar.f450173d.f450176a;
            if (i3 == 2 || i3 == 1) {
                spannableStringBuilder.append("\u200b");
            }
        }

        @Override // xd1.a.InterfaceC11539a
        public void b(SpannableStringBuilder spannableStringBuilder, yd1.b bVar) {
            this.f212913b = spannableStringBuilder.length();
            int i3 = bVar.f450173d.f450176a;
            if (i3 == 1) {
                spannableStringBuilder.setSpan(new zd1.b(ae1.a.c(), bVar.f450173d.f450178c), this.f212912a, this.f212913b, 33);
            } else if (i3 == 2) {
                int c16 = ae1.a.c();
                b.C11604b c11604b = bVar.f450173d;
                spannableStringBuilder.setSpan(new zd1.c(c11604b.f450177b, c16, c11604b.f450178c), this.f212912a, this.f212913b, 33);
            }
            if ("left".equals(bVar.f450173d.f450179d)) {
                spannableStringBuilder.setSpan(new AlignmentSpan(Layout.Alignment.ALIGN_NORMAL, false), this.f212912a, this.f212913b, 33);
            } else if ("center".equals(bVar.f450173d.f450179d)) {
                spannableStringBuilder.setSpan(new AlignmentSpan(Layout.Alignment.ALIGN_CENTER, false), this.f212912a, this.f212913b, 33);
            } else if ("right".equals(bVar.f450173d.f450179d)) {
                spannableStringBuilder.setSpan(new AlignmentSpan(Layout.Alignment.ALIGN_OPPOSITE, false), this.f212912a, this.f212913b, 33);
            }
            int i16 = bVar.f450173d.f450180e;
            if (i16 != 0) {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(ViewUtils.spToPx(i16)), this.f212912a, this.f212913b, 33);
            }
            spannableStringBuilder.append("\n");
        }

        @Override // xd1.a.InterfaceC11539a
        public void c(SpannableStringBuilder spannableStringBuilder, c.C11605c c11605c) {
            if (c11605c != null) {
                List<GameStrategyVideo> videos = QQGameStrategyAnswerControl.this.T0.getVideos();
                int i3 = c11605c.f450192c;
                if (i3 >= 0 && i3 < videos.size()) {
                    GameStrategyVideo gameStrategyVideo = videos.get(c11605c.f450192c);
                    if (gameStrategyVideo.isValid()) {
                        final GameStrategyImageSpan e16 = GameStrategyImageSpan.e(gameStrategyVideo.mCoverUrl, (int) (((float) com.tencent.mobileqq.utils.ah.M()) - (com.tencent.mobileqq.utils.ah.f307408i * 52.0f)), gameStrategyVideo.mLocalPath, gameStrategyVideo.mVideoUrl, gameStrategyVideo.mCoverWidth, gameStrategyVideo.mCoverHeight);
                        e16.H(gameStrategyVideo.mDuration);
                        e16.I(gameStrategyVideo.mVideoUrl);
                        e16.C(new GameStrategyImageSpan.a() { // from class: com.tencent.mobileqq.gamecenter.qa.view.ag
                            @Override // com.tencent.mobileqq.gamecenter.qa.view.GameStrategyImageSpan.a
                            public final void onClick(int i16) {
                                QQGameStrategyAnswerControl.b.this.k(e16, i16);
                            }
                        });
                        String n3 = e16.n(false);
                        int length = spannableStringBuilder.length();
                        int length2 = n3.length() + length;
                        spannableStringBuilder.append((CharSequence) n3);
                        spannableStringBuilder.append("\n");
                        spannableStringBuilder.setSpan(e16, length, length2, 33);
                        this.f212915d.add(e16);
                        return;
                    }
                    return;
                }
                QLog.e("QQGameStrategyBaseControl", 1, "onParseVideo, videoBlock index invalid=", Integer.valueOf(c11605c.f450192c));
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
                    ab l3 = ab.l(str2, str, QQGameStrategyAnswerControl.this.f213074y0);
                    String k3 = com.tencent.mobileqq.gamecenter.qa.manager.b.k(str, str2);
                    int length = spannableStringBuilder.length();
                    int length2 = k3.length() + length;
                    spannableStringBuilder.append((CharSequence) k3);
                    spannableStringBuilder.setSpan(l3, length, length2, 33);
                    this.f212916e.add(l3);
                    return;
                } catch (UnsupportedEncodingException e16) {
                    QLog.e("QQGameStrategyBaseControl", 1, "onParseRef, exception=", e16);
                    return;
                }
            }
            QLog.e("QQGameStrategyBaseControl", 1, "onParseRef, refBlock null");
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
                    ab l3 = ab.l(str2, str, QQGameStrategyAnswerControl.this.f213074y0);
                    String k3 = com.tencent.mobileqq.gamecenter.qa.manager.b.k(str, str2);
                    int length = spannableStringBuilder.length();
                    int length2 = k3.length() + length;
                    spannableStringBuilder.append((CharSequence) k3);
                    spannableStringBuilder.setSpan(l3, length, length2, 33);
                    this.f212917f.add(l3);
                } catch (UnsupportedEncodingException e16) {
                    QLog.e("QQGameStrategyBaseControl", 1, "onParseLinkSection, exception=", e16);
                }
            }
        }

        @Override // xd1.a.InterfaceC11539a
        public void g(SpannableStringBuilder spannableStringBuilder, c.a aVar) {
            if (aVar != null) {
                List<GameStrategyPic> pics = QQGameStrategyAnswerControl.this.T0.getPics();
                int i3 = aVar.f450188c;
                if (i3 >= 0 && i3 < pics.size()) {
                    GameStrategyPic gameStrategyPic = pics.get(aVar.f450188c);
                    if (gameStrategyPic.isCoverValid()) {
                        final GameStrategyImageSpan d16 = GameStrategyImageSpan.d(QQGameStrategyAnswerControl.this.E0(), (int) (((float) com.tencent.mobileqq.utils.ah.M()) - (com.tencent.mobileqq.utils.ah.f307408i * 52.0f)), gameStrategyPic.mLocalPath, gameStrategyPic.mUrl, gameStrategyPic.mWidth, gameStrategyPic.mHeight);
                        d16.C(new GameStrategyImageSpan.a() { // from class: com.tencent.mobileqq.gamecenter.qa.view.ah
                            @Override // com.tencent.mobileqq.gamecenter.qa.view.GameStrategyImageSpan.a
                            public final void onClick(int i16) {
                                QQGameStrategyAnswerControl.b.this.j(d16, i16);
                            }
                        });
                        String n3 = d16.n(false);
                        int length = spannableStringBuilder.length();
                        int length2 = n3.length() + length;
                        spannableStringBuilder.append((CharSequence) n3);
                        spannableStringBuilder.append("\n");
                        spannableStringBuilder.setSpan(d16, length, length2, 33);
                        this.f212914c.add(d16);
                        return;
                    }
                    return;
                }
                QLog.e("QQGameStrategyBaseControl", 1, "onParsePic, picBlock index invalid=", Integer.valueOf(aVar.f450188c));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c extends b.AbstractC7648b {
        c() {
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.s.b
        public void a(@Nullable String str, @Nullable String str2, @Nullable ab abVar) {
            if (QQGameStrategyAnswerControl.this.J == 0) {
                HashMap hashMap = new HashMap();
                hashMap.put(6, String.valueOf(QQGameStrategyAnswerControl.this.Q0.f212651b));
                com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102529", "907467", "20", String.valueOf(QQGameStrategyAnswerControl.this.Q0.f212650a), hashMap);
            }
        }
    }

    public QQGameStrategyAnswerControl(Activity activity, Context context, com.tencent.mobileqq.gamecenter.qa.model.h hVar, int i3, boolean z16) {
        super(activity, context, i3, z16);
        this.R0 = new fe1.c();
        this.U0 = new a();
        this.V0 = new c();
        this.Q0 = hVar;
        this.S0 = new GameStrategyDraftHandler(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D2(long j3, final long j16, int i3) {
        int i16;
        this.H.removeMessages(256);
        this.H.removeMessages(255);
        this.H.sendEmptyMessage(255);
        int i17 = 0;
        if (j3 == 0) {
            if (i3 == 1) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.af
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQGameStrategyAnswerControl.this.G2(j16);
                    }
                });
            } else {
                this.S0.d(this.Q0.f212651b);
                if (TextUtils.isEmpty(this.Q0.f212653d) && this.J == 0) {
                    j0(false);
                    GameQAUtil.w(A0().getIntent().getIntExtra("miniGameAppId", 0));
                } else {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.QQGameStrategyAnswerControl.4
                        @Override // java.lang.Runnable
                        public void run() {
                            GameQAUtil.A(QQGameStrategyAnswerControl.this.A0(), QQGameStrategyAnswerControl.this.Q0.f212650a, QQGameStrategyAnswerControl.this.Q0.f212651b, false, true, 0);
                            QQGameStrategyAnswerControl.this.j0(false);
                        }
                    });
                }
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
            IGameQAIpcApi iGameQAIpcApi = (IGameQAIpcApi) QRoute.api(IGameQAIpcApi.class);
            com.tencent.mobileqq.gamecenter.qa.model.h hVar = this.Q0;
            iGameQAIpcApi.callbackStrategyAnswer(i17, hVar.f212650a, hVar.f212651b, j16);
            a.Companion companion = com.tencent.mobileqq.gamecenter.qa.kuikly.a.INSTANCE;
            Activity A02 = A0();
            com.tencent.mobileqq.gamecenter.qa.model.h hVar2 = this.Q0;
            companion.a(A02, i17, hVar2.f212650a, hVar2.f212651b, j16);
        }
    }

    @NonNull
    private GameStrategyAnswer E2() {
        Editable editableText = this.f213056i.getEditableText();
        GameStrategyAnswer gameStrategyAnswer = new GameStrategyAnswer();
        com.tencent.mobileqq.gamecenter.qa.model.h hVar = this.Q0;
        gameStrategyAnswer.mAppId = hVar.f212650a;
        gameStrategyAnswer.mQuestionId = hVar.f212651b;
        bh.w I0 = I0(editableText);
        if (I0 != null) {
            gameStrategyAnswer.addPics(I0.f213109a);
            gameStrategyAnswer.addVideos(I0.f213110b);
            gameStrategyAnswer.addLinkCards(I0.f213111c);
            gameStrategyAnswer.mContent = I0.f213112d;
            yd1.d a16 = new xd1.b().a((SpannableStringBuilder) editableText);
            gameStrategyAnswer.mRichContent = a16.serialize().toString();
            if (QLog.isColorLevel()) {
                QLog.d("QQGameStrategyBaseControl", 2, "richText:", a16, " mRichContent:", gameStrategyAnswer.mRichContent);
            }
        }
        return gameStrategyAnswer;
    }

    private void F2() {
        if (!TextUtils.isEmpty(this.Q0.f212652c)) {
            this.P0.setText(this.Q0.f212652c);
        }
        this.R0.Z0(this.U0);
        H2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G2(long j3) {
        GameStrategyAnswer E2 = E2();
        E2.answerId = j3;
        this.S0.t(E2);
    }

    private void H2() {
        com.tencent.mobileqq.gamecenter.qa.model.h hVar = this.Q0;
        if (hVar.f212657h == 1) {
            this.T0 = this.S0.h(hVar.f212651b, hVar.f212656g);
        } else {
            this.T0 = this.S0.i(hVar.f212651b);
        }
        GameStrategyAnswer gameStrategyAnswer = this.T0;
        if (gameStrategyAnswer != null && !TextUtils.isEmpty(gameStrategyAnswer.mRichContent)) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            SpannableStringBuilder a16 = new xd1.a().a(yd1.d.d(this.T0.mRichContent), new b(arrayList3, arrayList4, arrayList2, arrayList));
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
            this.f213047d.t(A0(), this.f213056i, this.f213074y0, arrayList, this.K, this.V0);
            this.f213047d.t(A0(), this.f213056i, this.f213074y0, arrayList2, this.K, this.V0);
            Iterator it6 = arrayList2.iterator();
            while (it6.hasNext()) {
                ((ab) it6.next()).B(A0(), null, "");
            }
            GameStrategyEditTextView gameStrategyEditTextView = this.f213056i;
            gameStrategyEditTextView.setSelection(gameStrategyEditTextView.getEditableText().length());
            this.f213056i.e0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public int B0() {
        com.tencent.mobileqq.gamecenter.qa.model.h hVar = this.Q0;
        if (hVar != null) {
            return hVar.f212650a;
        }
        return super.B0();
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    protected int D0() {
        return R.layout.f167994ec4;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    protected File F0() {
        return GameStrategyDraftHandler.j(this.Q0.f212651b);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    protected EditText G0() {
        return this.f213056i;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public s.b H0() {
        return this.V0;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    protected long J0() {
        com.tencent.mobileqq.gamecenter.qa.model.h hVar = this.Q0;
        if (hVar != null) {
            return hVar.f212651b;
        }
        return super.B0();
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    protected void J1() {
        HashMap hashMap = new HashMap();
        hashMap.put(6, String.valueOf(this.Q0.f212651b));
        com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102529", "912824", "8", String.valueOf(this.Q0.f212650a), hashMap);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    protected void K1() {
        HashMap hashMap = new HashMap();
        hashMap.put(6, String.valueOf(this.Q0.f212651b));
        com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102529", "912823", "20", String.valueOf(this.Q0.f212650a), hashMap);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    protected String L0() {
        return E0().getResources().getString(R.string.f1369005e);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    protected void Q0(GameQALinkCardData gameQALinkCardData) {
        if (gameQALinkCardData != null) {
            this.f213047d.m(A0(), G0(), gameQALinkCardData, true, this.K, this.V0);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    protected void R1(boolean z16) {
        String str;
        HashMap hashMap = new HashMap();
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put(2, str);
        com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102529", "912956", "20", String.valueOf(this.Q0.f212650a), hashMap);
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
        com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102529", "912957", "20", String.valueOf(this.Q0.f212650a), hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public void W1() {
        long j3;
        super.W1();
        if (!c1()) {
            QQToast.makeText(A0(), R.string.f1370405s, 0).show();
            return;
        }
        if (this.J == 0) {
            com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102529", "209613", "20", String.valueOf(this.Q0.f212650a), null);
        } else {
            String valueOf = String.valueOf(this.Q0.f212650a);
            Activity A0 = A0();
            com.tencent.mobileqq.gamecenter.qa.model.h hVar = this.Q0;
            com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907129", "20", valueOf, GameQAUtil.j(A0, hVar.f212654e, hVar.f212651b));
        }
        GameStrategyAnswer E2 = E2();
        if (this.J == 1) {
            E2.channelEntry = this.Q0.f212654e;
            this.R0.Q0(E2);
        } else {
            fe1.c cVar = this.R0;
            GameStrategyAnswer gameStrategyAnswer = this.T0;
            if (gameStrategyAnswer != null) {
                j3 = gameStrategyAnswer.answerId;
            } else {
                j3 = 0;
            }
            cVar.S0(E2, j3);
        }
        GameQAUtil.B();
        this.H.removeMessages(256);
        this.H.sendEmptyMessageDelayed(256, 500L);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public void X1() {
        long j3;
        super.X1();
        if (!c1()) {
            QQToast.makeText(A0(), R.string.f1370405s, 0).show();
            return;
        }
        GameStrategyAnswer gameStrategyAnswer = this.T0;
        if (gameStrategyAnswer != null) {
            j3 = gameStrategyAnswer.answerId;
        } else {
            j3 = 0;
        }
        if (this.J == 0) {
            GameStrategyAnswer E2 = E2();
            this.H.removeMessages(256);
            this.H.sendEmptyMessageDelayed(256, 500L);
            this.R0.P0(E2, j3);
            HashMap hashMap = new HashMap();
            hashMap.put(6, String.valueOf(this.Q0.f212651b));
            com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102529", "209892", "20", String.valueOf(this.Q0.f212650a), hashMap);
            return;
        }
        GameStrategyAnswer E22 = E2();
        E22.answerId = j3;
        this.S0.t(E22);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public void Z0() {
        super.Z0();
        if (this.J == 0) {
            HashMap hashMap = new HashMap();
            hashMap.put(6, String.valueOf(this.Q0.f212651b));
            com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102529", "209611", "20", String.valueOf(this.Q0.f212650a), hashMap);
        } else {
            String valueOf = String.valueOf(this.Q0.f212650a);
            Activity A0 = A0();
            com.tencent.mobileqq.gamecenter.qa.model.h hVar = this.Q0;
            com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907127", "20", valueOf, GameQAUtil.j(A0, hVar.f212654e, hVar.f212651b));
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    protected void b0(String str) {
        if (this.f213074y0 && this.f213047d != null) {
            Editable editableText = this.f213056i.getEditableText();
            int lastIndexOf = editableText.toString().lastIndexOf(str);
            editableText.delete(lastIndexOf, str.length() + lastIndexOf);
            this.f213047d.n(A0(), G0(), str, this.f213074y0, this.K, this.V0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public void f0() {
        super.f0();
        if (this.J == 0) {
            HashMap hashMap = new HashMap();
            hashMap.put(6, String.valueOf(this.Q0.f212651b));
            com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102529", "209612", "20", String.valueOf(this.Q0.f212650a), hashMap);
        } else {
            String valueOf = String.valueOf(this.Q0.f212650a);
            Activity A0 = A0();
            com.tencent.mobileqq.gamecenter.qa.model.h hVar = this.Q0;
            com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907128", "20", valueOf, GameQAUtil.j(A0, hVar.f212654e, hVar.f212651b));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public void g0() {
        super.g0();
        this.f213047d.l(A0(), G0(), this.f213074y0, this.K, this.V0);
        HashMap hashMap = new HashMap();
        hashMap.put(6, String.valueOf(this.Q0.f212651b));
        com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102529", "912825", "20", String.valueOf(this.Q0.f212650a), hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public void i0() {
        super.i0();
        if (this.J == 0) {
            HashMap hashMap = new HashMap();
            hashMap.put(6, String.valueOf(this.Q0.f212651b));
            com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102529", "907214", "20", String.valueOf(this.Q0.f212650a), hashMap);
        } else {
            String valueOf = String.valueOf(this.Q0.f212650a);
            Activity A0 = A0();
            com.tencent.mobileqq.gamecenter.qa.model.h hVar = this.Q0;
            com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907436", "20", valueOf, GameQAUtil.j(A0, hVar.f212654e, hVar.f212651b));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public boolean k0() {
        if (this.f213056i.getEditableText().length() > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put(6, String.valueOf(this.Q0.f212651b));
            com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102529", "209891", "8", String.valueOf(this.Q0.f212650a), hashMap);
            return super.k0();
        }
        GameQAUtil.w(A0().getIntent().getIntExtra("miniGameAppId", 0));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public void p0(LayoutInflater layoutInflater, @android.support.annotation.Nullable ViewGroup viewGroup, @android.support.annotation.Nullable Bundle bundle) {
        super.p0(layoutInflater, viewGroup, bundle);
        j2(R.string.f13714062, false);
        TextView textView = (TextView) this.f213054h.findViewById(R.id.f88614xj);
        this.P0 = textView;
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.F.setVisibility(8);
        F2();
        if (this.J == 0) {
            HashMap hashMap = new HashMap();
            hashMap.put(6, String.valueOf(this.Q0.f212651b));
            com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102529", "209610", "7", String.valueOf(this.Q0.f212650a), hashMap);
        } else {
            String valueOf = String.valueOf(this.Q0.f212650a);
            Activity A0 = A0();
            com.tencent.mobileqq.gamecenter.qa.model.h hVar = this.Q0;
            com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907126", "8", valueOf, GameQAUtil.j(A0, hVar.f212654e, hVar.f212651b));
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public void q0() {
        super.q0();
        this.R0.N0();
        QQProgressDialog qQProgressDialog = this.G;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
        }
        this.H.removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public void r0() {
        super.r0();
        InputMethodUtil.hide(this.f213056i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public void s0(boolean z16, boolean z17) {
        super.s0(z16, z17);
        if (z16) {
            this.P0.setTextColor(this.I.getResources().getColor(R.color.cg8));
        } else {
            if (!z17) {
                return;
            }
            this.P0.setTextColor(this.I.getResources().getColor(R.color.cg7));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    public void y0() {
        super.y0();
        this.S0.d(this.Q0.f212651b);
        if (this.J == 0) {
            HashMap hashMap = new HashMap();
            hashMap.put(6, String.valueOf(this.Q0.f212651b));
            com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102529", "209893", "20", String.valueOf(this.Q0.f212650a), hashMap);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.bh
    protected boolean z0() {
        return true;
    }
}
