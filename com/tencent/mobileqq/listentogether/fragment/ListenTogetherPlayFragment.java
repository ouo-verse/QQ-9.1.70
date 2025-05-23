package com.tencent.mobileqq.listentogether.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qzone.proxy.feedcomponent.model.CellDynamicAlbum;
import com.tencent.common.config.AppSetting;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserMiniAIOHelper;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.listentogether.ListenTogetherHandler;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.e;
import com.tencent.mobileqq.lyric.widget.LyricViewController;
import com.tencent.mobileqq.lyric.widget.LyricViewDetail;
import com.tencent.mobileqq.musicgene.a;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes33.dex */
public class ListenTogetherPlayFragment extends PublicBaseFragment implements View.OnClickListener {
    View C;
    View D;
    View E;
    TextView F;
    TextView G;
    TextView H;
    View I;
    TextView J;
    ImageView K;
    ImageView L;
    ImageView M;
    ImageView N;
    View P;
    LyricViewDetail Q;
    LyricViewController R;
    URLImageView S;
    ImageView T;
    ImageView U;
    AvatarLayout W;
    FileBrowserMiniAIOHelper X;
    ListenTogetherHandler Y;
    ListenTogetherManager Z;

    /* renamed from: a0, reason: collision with root package name */
    QQAppInterface f240950a0;

    /* renamed from: b0, reason: collision with root package name */
    ISong f240951b0;

    /* renamed from: c0, reason: collision with root package name */
    ListenTogetherSession f240952c0;

    /* renamed from: d0, reason: collision with root package name */
    boolean f240953d0;

    /* renamed from: f0, reason: collision with root package name */
    String f240955f0;
    ImageView[] V = new ImageView[5];

    /* renamed from: e0, reason: collision with root package name */
    boolean f240954e0 = false;

    /* renamed from: g0, reason: collision with root package name */
    a.InterfaceC8126a f240956g0 = new a.InterfaceC8126a() { // from class: com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment.1
        @Override // com.tencent.mobileqq.musicgene.a.InterfaceC8126a
        public void a(final String str, final int i3, final int i16, Object obj) {
            ListenTogetherPlayFragment.this.getBaseActivity().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (str.equals(ListenTogetherPlayFragment.this.f240951b0.getAlbum())) {
                        ListenTogetherPlayFragment.this.Gh(i3, i16, false);
                    }
                }
            });
        }
    };

    /* renamed from: h0, reason: collision with root package name */
    e f240957h0 = new a();

    /* renamed from: i0, reason: collision with root package name */
    View.OnTouchListener f240958i0 = new b();

    /* loaded from: classes33.dex */
    class a extends e {
        a() {
        }

        @Override // com.tencent.mobileqq.listentogether.e
        protected void a(int i3, String str) {
            BaseActivity baseActivity = ListenTogetherPlayFragment.this.getBaseActivity();
            if (baseActivity == null || baseActivity.isFinishing() || !ListenTogetherPlayFragment.this.isAdded()) {
                return;
            }
            String str2 = ListenTogetherPlayFragment.this.f240952c0.f437189f;
            if (str2.equals(str2)) {
                if (QLog.isColorLevel()) {
                    QLog.i("ListenTogetherPlayFragment", 2, String.format("onChangePlayModeListenTogetherFail [%s, %d]", str, Integer.valueOf(i3)));
                }
                QQToast.makeText(baseActivity, R.string.isk, 1).show();
            }
        }

        @Override // com.tencent.mobileqq.listentogether.e
        protected void b(int i3, String str) {
            BaseActivity baseActivity = ListenTogetherPlayFragment.this.getBaseActivity();
            if (baseActivity == null || baseActivity.isFinishing() || !ListenTogetherPlayFragment.this.isAdded()) {
                return;
            }
            String str2 = ListenTogetherPlayFragment.this.f240952c0.f437189f;
            if (str2.equals(str2)) {
                if (QLog.isColorLevel()) {
                    QLog.i("ListenTogetherPlayFragment", 2, String.format("onCutListenTogetherFail [%s, %d]", str, Integer.valueOf(i3)));
                }
                QQToast.makeText(baseActivity, R.string.irx, 1).show();
            }
        }

        @Override // com.tencent.mobileqq.listentogether.e
        protected void e(boolean z16, String str, int i3, List<String> list) {
            BaseActivity baseActivity = ListenTogetherPlayFragment.this.getBaseActivity();
            if (baseActivity == null || baseActivity.isFinishing() || !ListenTogetherPlayFragment.this.isAdded() || !ListenTogetherPlayFragment.this.f240952c0.f437189f.equals(str)) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ListenTogetherPlayFragment", 2, String.format("onGetGroupJoinedUsers uin=%s num=%d", str, Integer.valueOf(i3)));
            }
            ListenTogetherPlayFragment listenTogetherPlayFragment = ListenTogetherPlayFragment.this;
            listenTogetherPlayFragment.Kh(list, listenTogetherPlayFragment.f240952c0.N);
        }

        @Override // com.tencent.mobileqq.listentogether.e
        protected void f(String str, String str2, boolean z16) {
            BaseActivity baseActivity = ListenTogetherPlayFragment.this.getBaseActivity();
            if (baseActivity == null || baseActivity.isFinishing() || !ListenTogetherPlayFragment.this.isAdded() || !ListenTogetherPlayFragment.this.f240951b0.getId().equals(str)) {
                return;
            }
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[2];
                objArr[0] = str;
                objArr[1] = Integer.valueOf(str2 != null ? str2.length() : 0);
                QLog.i("ListenTogetherPlayFragment", 2, String.format("onGetLyric %s %d", objArr));
            }
            ListenTogetherPlayFragment listenTogetherPlayFragment = ListenTogetherPlayFragment.this;
            listenTogetherPlayFragment.f240955f0 = str2;
            listenTogetherPlayFragment.Lh(str, listenTogetherPlayFragment.f240952c0.f437191i, str2);
        }

        @Override // com.tencent.mobileqq.listentogether.e
        protected void j(int i3, String str, String str2) {
            BaseActivity baseActivity = ListenTogetherPlayFragment.this.getBaseActivity();
            if (baseActivity == null || baseActivity.isFinishing() || !ListenTogetherPlayFragment.this.isAdded() || !ListenTogetherPlayFragment.this.f240952c0.f437189f.equals(str)) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ListenTogetherPlayFragment", 2, String.format("onListenTogetherJoinedCountChange msg=%s", str2));
            }
            ListenTogetherPlayFragment listenTogetherPlayFragment = ListenTogetherPlayFragment.this;
            listenTogetherPlayFragment.f240952c0.N = str2;
            if (i3 != 1) {
                listenTogetherPlayFragment.Kh(listenTogetherPlayFragment.Bh(), ListenTogetherPlayFragment.this.f240952c0.N);
            } else {
                listenTogetherPlayFragment.Y.G2(str);
            }
        }

        @Override // com.tencent.mobileqq.listentogether.e
        protected void o(int i3, String str) {
            BaseActivity baseActivity = ListenTogetherPlayFragment.this.getBaseActivity();
            if (baseActivity == null || baseActivity.isFinishing() || !ListenTogetherPlayFragment.this.isAdded()) {
                return;
            }
            String str2 = ListenTogetherPlayFragment.this.f240952c0.f437189f;
            if (str2.equals(str2)) {
                if (QLog.isColorLevel()) {
                    QLog.i("ListenTogetherPlayFragment", 2, String.format("onPauseListenTogetherFail [%s, %d]", str, Integer.valueOf(i3)));
                }
                QQToast.makeText(baseActivity, R.string.isj, 1).show();
            }
        }

        @Override // com.tencent.mobileqq.listentogether.e
        protected void p(ISong iSong) {
            BaseActivity baseActivity = ListenTogetherPlayFragment.this.getBaseActivity();
            if (baseActivity == null || baseActivity.isFinishing() || !ListenTogetherPlayFragment.this.isAdded() || ListenTogetherPlayFragment.this.f240951b0.equals(iSong)) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ListenTogetherPlayFragment", 2, String.format("onPlayMusicChange %s", iSong));
            }
            ListenTogetherPlayFragment listenTogetherPlayFragment = ListenTogetherPlayFragment.this;
            listenTogetherPlayFragment.f240951b0 = iSong;
            listenTogetherPlayFragment.f240955f0 = null;
            listenTogetherPlayFragment.Jh(iSong);
        }

        @Override // com.tencent.mobileqq.listentogether.e
        protected void s(int i3, String str) {
            BaseActivity baseActivity = ListenTogetherPlayFragment.this.getBaseActivity();
            if (baseActivity == null || baseActivity.isFinishing() || !ListenTogetherPlayFragment.this.isAdded()) {
                return;
            }
            String str2 = ListenTogetherPlayFragment.this.f240952c0.f437189f;
            if (str2.equals(str2)) {
                if (QLog.isColorLevel()) {
                    QLog.i("ListenTogetherPlayFragment", 2, String.format("onResumeListenTogetherFail [%s, %d]", str, Integer.valueOf(i3)));
                }
                QQToast.makeText(baseActivity, R.string.isn, 1).show();
            }
        }

        @Override // com.tencent.mobileqq.listentogether.e
        protected void u(ListenTogetherSession listenTogetherSession) {
            int i3;
            BaseActivity baseActivity = ListenTogetherPlayFragment.this.getBaseActivity();
            if (baseActivity == null || baseActivity.isFinishing() || !ListenTogetherPlayFragment.this.isAdded() || !ListenTogetherPlayFragment.this.f240952c0.f437189f.equals(listenTogetherSession.f437189f)) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ListenTogetherPlayFragment", 2, String.format("onUIModuleNeedRefresh session=%s", listenTogetherSession));
            }
            ListenTogetherPlayFragment.this.f240952c0 = listenTogetherSession;
            MusicInfo c16 = listenTogetherSession.c();
            if (listenTogetherSession.f437192m == 2 && (i3 = listenTogetherSession.f437191i) != 3 && i3 != 4 && c16 != null) {
                p(c16);
                ListenTogetherPlayFragment listenTogetherPlayFragment = ListenTogetherPlayFragment.this;
                listenTogetherPlayFragment.Lh(listenTogetherPlayFragment.f240951b0.getId(), listenTogetherSession.f437191i, ListenTogetherPlayFragment.this.f240955f0);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i("ListenTogetherPlayFragment", 2, "onExit");
                }
                QQToast.makeText(baseActivity, R.string.isa, 1).show();
                ListenTogetherPlayFragment.this.getBaseActivity().finish();
            }
        }
    }

    /* loaded from: classes33.dex */
    class b implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        float f240969d = 0.0f;

        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                float alpha = view.getAlpha();
                this.f240969d = alpha;
                view.setAlpha(alpha * 0.5f);
                return false;
            }
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return false;
            }
            view.setAlpha(this.f240969d);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> Bh() {
        int b16 = this.f240952c0.b();
        if (QLog.isColorLevel()) {
            QLog.i("ListenTogetherPlayFragment", 2, String.format("getC2CUins status=%d msg=%s", Integer.valueOf(b16), this.f240952c0.N));
        }
        ArrayList arrayList = new ArrayList();
        if (b16 == 1) {
            arrayList.add(this.f240950a0.getCurrentAccountUin());
        } else if (b16 == 2) {
            arrayList.add(this.f240952c0.f437189f);
        } else if (b16 == 3) {
            arrayList.add(this.f240950a0.getCurrentAccountUin());
            arrayList.add(this.f240952c0.f437189f);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Eh(String str) {
        this.G.setText(str);
        return null;
    }

    private void Fh(String str, LyricViewDetail lyricViewDetail) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.mobileqq.lyric.data.b a16 = com.tencent.mobileqq.lyric.util.b.a(str, true);
        if (a16 == null) {
            a16 = com.tencent.mobileqq.lyric.util.b.a(str, false);
        }
        if (a16 == null) {
            return;
        }
        this.R.m();
        lyricViewDetail.a().setHighlightCurrentLine(true);
        lyricViewDetail.a().setHighlightLineNumber(2);
        this.R.k(lyricViewDetail);
        this.R.j(a16, a16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gh(int i3, int i16, boolean z16) {
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || baseActivity.isFinishing() || !isAdded()) {
            return;
        }
        int i17 = 0;
        if (QLog.isColorLevel()) {
            QLog.i("ListenTogetherPlayFragment", 2, String.format("onGetColors [0x%x 0x%x]", Integer.valueOf(i3), Integer.valueOf(i16)));
        }
        int argb = Color.argb(0, Color.red(i3), Color.green(i3), Color.blue(i3));
        this.T.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{i3, argb, argb, argb, argb, argb, i3}));
        this.C.setBackgroundColor(i3);
        if (z16) {
            this.S.setBackgroundColor(i3);
            this.T.setImageResource(R.drawable.listen_together_album_default);
            this.T.setScaleType(ImageView.ScaleType.CENTER);
        } else {
            this.S.setBackgroundColor(0);
            this.T.setImageDrawable(null);
        }
        int argb2 = Color.argb(128, Color.red(i16), Color.green(i16), Color.blue(i16));
        this.F.setTextColor(i16);
        this.G.setTextColor(i16);
        this.J.setTextColor(i16);
        this.H.setTextColor(i16);
        this.Q.a().setLyricHilightColor(i16);
        this.Q.a().setLyricColor(argb2);
        this.K.setColorFilter(i16, PorterDuff.Mode.SRC_IN);
        this.L.setColorFilter(i16, PorterDuff.Mode.SRC_IN);
        this.M.setColorFilter(i16, PorterDuff.Mode.SRC_IN);
        this.N.setColorFilter(i16, PorterDuff.Mode.SRC_IN);
        this.U.setColorFilter(i16, PorterDuff.Mode.SRC_IN);
        AvatarLayout avatarLayout = this.W;
        if (avatarLayout != null) {
            xh(((DynamicAvatarView) avatarLayout.findViewById(R.id.a6e)).getBackground(), i16);
        }
        while (true) {
            ImageView[] imageViewArr = this.V;
            if (i17 >= imageViewArr.length) {
                break;
            }
            ImageView imageView = imageViewArr[i17];
            xh(imageView.getBackground(), i16);
            imageView.setTag(Integer.valueOf(i16));
            i17++;
        }
        Drawable drawable = getResources().getDrawable(R.drawable.hnp);
        drawable.setColorFilter(i16, PorterDuff.Mode.SRC_IN);
        this.H.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        if (this.f240952c0.f437188e == 1) {
            this.J.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        } else {
            this.J.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        Drawable background = this.H.getBackground();
        if (background != null) {
            background.setColorFilter(i16, PorterDuff.Mode.SRC_IN);
        }
    }

    private void Ih(String str, ImageView imageView) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f240950a0 != null) {
            Drawable defaultFaceDrawable = BaseImageUtil.getDefaultFaceDrawable(true);
            FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(this.f240950a0, 1, str, 4, defaultFaceDrawable, defaultFaceDrawable);
            Drawable drawable = imageView.getDrawable();
            if (drawable != null && drawable != faceDrawable && (drawable instanceof FaceDrawable)) {
                ((FaceDrawable) drawable).cancel();
            }
            imageView.setImageDrawable(faceDrawable);
            imageView.setVisibility(0);
            if (imageView.getBackground() == null || !(imageView.getBackground() instanceof ShapeDrawable)) {
                return;
            }
            Object tag = imageView.getTag();
            if (tag instanceof Integer) {
                ((ShapeDrawable) imageView.getBackground()).getPaint().setColor(((Integer) tag).intValue());
                return;
            }
            return;
        }
        imageView.setImageDrawable(BaseImageUtil.getDefaultFaceDrawable(true));
        imageView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jh(ISong iSong) {
        int i3;
        this.F.setText(iSong.getTitle());
        String album = iSong.getAlbum();
        if (TextUtils.isEmpty(album) || !Patterns.WEB_URL.matcher(album).matches()) {
            i3 = 0;
        } else {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            obtain.mMemoryCacheKeySuffix = "original";
            URLDrawable drawable2 = URLDrawable.getDrawable(iSong.getAlbum(), obtain);
            List<Integer> a16 = com.tencent.mobileqq.musicgene.a.a(iSong.getAlbum());
            if (a16 != null) {
                Gh(a16.get(0).intValue(), a16.get(1).intValue(), false);
                i3 = 1;
            } else {
                final com.tencent.mobileqq.musicgene.a aVar = new com.tencent.mobileqq.musicgene.a(album, this.f240956g0, null);
                if (drawable2.getStatus() == 1) {
                    Drawable currDrawable = drawable2.getCurrDrawable();
                    if (currDrawable instanceof RegionDrawable) {
                        final Bitmap bitmap = ((RegionDrawable) currDrawable).getBitmap();
                        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment.2
                            @Override // java.lang.Runnable
                            public void run() {
                                aVar.run(null, bitmap);
                            }
                        }, null, true);
                    }
                    i3 = 2;
                } else {
                    drawable2.setDecodeHandler(aVar);
                    i3 = 3;
                }
            }
            this.S.setImageDrawable(drawable2);
        }
        if (QLog.isColorLevel()) {
            QLog.i("ListenTogetherPlayFragment", 2, String.format("updateSongInfo type=%d album=%s", Integer.valueOf(i3), album));
        }
        String g16 = MusicInfo.g(iSong.J());
        int f16 = MusicInfo.f(iSong.J());
        if (iSong.H() > 0) {
            QQAppInterface qQAppInterface = this.f240950a0;
            ListenTogetherSession listenTogetherSession = this.f240952c0;
            MusicInfo.e(qQAppInterface, listenTogetherSession.f437188e, listenTogetherSession.f437189f, iSong.H(), new Function1() { // from class: com.tencent.mobileqq.listentogether.fragment.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit Eh;
                    Eh = ListenTogetherPlayFragment.this.Eh((String) obj);
                    return Eh;
                }
            });
            this.H.setVisibility(4);
            f16 = 0;
        } else {
            this.H.setVisibility(0);
            this.G.setText(g16);
        }
        TextView textView = this.H;
        textView.setClickable(textView.getVisibility() == 0);
        if (f16 != 0) {
            this.G.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(f16), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.G.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lh(String str, final int i3, String str2) {
        final boolean z16;
        String str3 = (String) this.Q.getTag();
        if (TextUtils.isEmpty(str2)) {
            this.Q.setVisibility(4);
            this.R.m();
        } else {
            if (this.Q.a().d() == null || !Utils.p(str3, str)) {
                Fh(str2, this.Q);
                this.Q.setTag(str);
                z16 = true;
            } else {
                z16 = false;
            }
            this.Q.setVisibility(0);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    long U = ListenTogetherPlayFragment.this.Z.U();
                    int i16 = (int) U;
                    int i17 = i3;
                    if (i17 != 1) {
                        if (2 == i17) {
                            if (i16 >= 0) {
                                ListenTogetherPlayFragment.this.R.i(i16);
                            }
                            ListenTogetherPlayFragment.this.R.h();
                            return;
                        }
                        ListenTogetherPlayFragment.this.R.m();
                        return;
                    }
                    boolean c16 = ListenTogetherPlayFragment.this.R.c();
                    if (!c16) {
                        ListenTogetherPlayFragment.this.R.l();
                    }
                    QLog.i("ListenTogetherPlayFragment", 1, "updateLyricPosition() try to seek! playPosition:" + U + " seekPosition:" + i16 + " isPlaying:" + c16);
                    if (i16 >= 0 || z16) {
                        LyricViewController lyricViewController = ListenTogetherPlayFragment.this.R;
                        if (i16 < 0) {
                            i16 = 0;
                        }
                        lyricViewController.i(i16);
                    }
                }
            }, 32, null, true);
        }
        if (i3 == 1) {
            ImageView imageView = this.K;
            imageView.setContentDescription(imageView.getContext().getString(R.string.isi));
            this.K.setImageResource(R.drawable.hnr);
        } else {
            ImageView imageView2 = this.K;
            imageView2.setContentDescription(imageView2.getContext().getString(R.string.f1625520q));
            this.K.setImageResource(R.drawable.hns);
        }
        if (!wh()) {
            this.K.setAlpha(0.2f);
            this.L.setVisibility(4);
            this.N.setVisibility(4);
            this.M.setVisibility(4);
        } else {
            this.K.setAlpha(1.0f);
            this.L.setVisibility(0);
            this.N.setVisibility(0);
            this.M.setVisibility(0);
        }
        int i16 = this.f240952c0.V;
        if (i16 == 1) {
            this.L.setImageResource(R.drawable.hny);
            this.L.setContentDescription("\u5207\u6362\u64ad\u653e\u6a21\u5f0f \u5f53\u524d\u4e3a\u5355\u66f2\u5faa\u73af");
        } else if (i16 == 2) {
            this.L.setImageResource(R.drawable.hnu);
            this.L.setContentDescription("\u5207\u6362\u64ad\u653e\u6a21\u5f0f \u5f53\u524d\u4e3a\u987a\u5e8f\u64ad\u653e");
        } else {
            if (i16 != 3) {
                return;
            }
            this.L.setImageResource(R.drawable.hnx);
            this.L.setContentDescription("\u5207\u6362\u64ad\u653e\u6a21\u5f0f \u5f53\u524d\u4e3a\u968f\u673a\u64ad\u653e");
        }
    }

    private void init() {
        this.Z = (ListenTogetherManager) this.f240950a0.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER);
        this.Y = (ListenTogetherHandler) this.f240950a0.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
        this.f240950a0.addObserver(this.f240957h0);
        int[] d16 = com.tencent.mobileqq.musicgene.c.d(-1315339);
        Gh(d16[0], d16[1], true);
        Jh(this.f240951b0);
        this.f240955f0 = this.Z.R(this.f240951b0.getId());
        Lh(this.f240951b0.getId(), this.f240952c0.f437191i, this.f240955f0);
        ListenTogetherSession listenTogetherSession = this.f240952c0;
        if (listenTogetherSession.f437188e == 1) {
            this.Y.G2(listenTogetherSession.f437189f);
        }
        Kh(Bh(), this.f240952c0.N);
        ListenTogetherManager.J(this.f240950a0).T().T(true);
        this.f240954e0 = true;
    }

    private void vh() {
        int screenWidth = ViewUtils.getScreenWidth();
        int screenHeight = ViewUtils.getScreenHeight();
        if (screenHeight <= 0 || screenWidth <= 0) {
            return;
        }
        int i3 = screenHeight - screenWidth;
        int dip2px = i3 - ViewUtils.dip2px(312.0f);
        if (QLog.isColorLevel()) {
            QLog.i("ListenTogetherPlayFragment", 2, "adjustLayout screenHeight = " + screenHeight + ", screenWidth = " + screenWidth + ", bottomHeight = " + i3 + ", heightSpacing = " + dip2px);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.D.getLayoutParams();
        if (AppSetting.o(getContext())) {
            try {
                int i16 = 0;
                if (getResources().getConfiguration().orientation == 2) {
                    int dip2px2 = screenWidth - ViewUtils.dip2px(312.0f);
                    if (dip2px2 >= 0) {
                        i16 = dip2px2;
                    }
                    layoutParams.removeRule(3);
                    layoutParams.topMargin = i16;
                } else {
                    layoutParams.addRule(3, this.D.getId());
                    layoutParams.topMargin = 0;
                    if (this.D.getWidth() > this.D.getHeight()) {
                        layoutParams2.height = this.D.getHeight();
                    }
                }
            } catch (Exception e16) {
                QLog.w("ListenTogetherPlayFragment", 2, "adjustLayout error : ", e16);
            }
        }
        if (dip2px < 0) {
            if (dip2px > ViewUtils.dip2px(50.0f) * (-1)) {
                layoutParams.topMargin = dip2px;
            } else {
                layoutParams.topMargin = dip2px + ViewUtils.dip2px(34.0f);
            }
            layoutParams.addRule(3, this.D.getId());
        }
    }

    private boolean wh() {
        return this.f240953d0 || this.f240950a0.getCurrentAccountUin().equalsIgnoreCase(this.f240952c0.C);
    }

    private void xh(Drawable drawable, int i3) {
        if (drawable instanceof ShapeDrawable) {
            ((ShapeDrawable) drawable).getPaint().setColor(i3);
        } else if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setColor(i3);
        }
        if (drawable != null) {
            drawable.invalidateSelf();
        }
    }

    private boolean zh() {
        Bundle arguments = getArguments();
        this.f240951b0 = (ISong) arguments.getParcelable("song");
        this.f240952c0 = (ListenTogetherSession) arguments.getParcelable(SessionDbHelper.SESSION_ID);
        this.f240953d0 = arguments.getBoolean("isAdmin");
        return (this.f240951b0 == null || this.f240952c0 == null) ? false : true;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        activity.getWindow().addFlags(256);
        activity.overridePendingTransition(R.anim.f154454a3, R.anim.f154442w);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        if (getBaseActivity() == null || getBaseActivity().isFinishing() || !isAdded()) {
            return;
        }
        boolean isNetworkAvailable = NetworkUtil.isNetworkAvailable(getBaseActivity());
        int id5 = view.getId();
        if (id5 != R.id.lzo) {
            if (id5 == R.id.lzn) {
                if (wh()) {
                    if (!isNetworkAvailable) {
                        QQToast.makeText(getBaseActivity(), 1, getBaseActivity().getString(R.string.f171155cp4), 0).show();
                        return;
                    }
                    int i3 = this.f240952c0.V + 1;
                    int i16 = i3 <= 3 ? i3 : 1;
                    ListenTogetherManager J = ListenTogetherManager.J(this.f240950a0);
                    ListenTogetherSession listenTogetherSession = this.f240952c0;
                    J.N0(listenTogetherSession.f437188e, listenTogetherSession.f437189f, i16);
                    ReportController.o(null, "dc00899", Ch(this.f240952c0.f437188e), "", "music_tab", "clk_mode", 0, 0, "", "", "" + i16, "");
                    return;
                }
                return;
            }
            if (id5 == R.id.lzk) {
                if (wh()) {
                    if (!isNetworkAvailable) {
                        QQToast.makeText(getBaseActivity(), 1, getBaseActivity().getString(R.string.f171155cp4), 0).show();
                        return;
                    }
                    ListenTogetherManager J2 = ListenTogetherManager.J(this.f240950a0);
                    ListenTogetherSession listenTogetherSession2 = this.f240952c0;
                    J2.S0(listenTogetherSession2.f437188e, listenTogetherSession2.f437189f, 2);
                    ReportController.o(null, "dc00899", Ch(this.f240952c0.f437188e), "", "music_tab", "clk_cut", 0, 0, "", "", "", "");
                    return;
                }
                return;
            }
            if (id5 == R.id.lzj) {
                if (wh()) {
                    if (!isNetworkAvailable) {
                        QQToast.makeText(getBaseActivity(), 1, getBaseActivity().getString(R.string.f171155cp4), 0).show();
                        return;
                    }
                    ListenTogetherManager J3 = ListenTogetherManager.J(this.f240950a0);
                    ListenTogetherSession listenTogetherSession3 = this.f240952c0;
                    J3.S0(listenTogetherSession3.f437188e, listenTogetherSession3.f437189f, 1);
                    ReportController.o(null, "dc00899", Ch(this.f240952c0.f437188e), "", "music_tab", "clk_cut", 0, 0, "", "", "", "");
                    return;
                }
                return;
            }
            if (id5 == R.id.f3m) {
                getBaseActivity().finish();
                return;
            }
            if (id5 == R.id.mau) {
                if (!isNetworkAvailable) {
                    QQToast.makeText(getBaseActivity(), 1, getBaseActivity().getString(R.string.f171155cp4), 0).show();
                    return;
                }
                if (this.f240952c0.f437188e == 1) {
                    QQAppInterface qQAppInterface = this.f240950a0;
                    BaseActivity baseActivity = getBaseActivity();
                    ListenTogetherSession listenTogetherSession4 = this.f240952c0;
                    d72.b.n(qQAppInterface, baseActivity, listenTogetherSession4.f437188e, listenTogetherSession4.f437189f);
                }
                ListenTogetherSession listenTogetherSession5 = this.f240952c0;
                yh(listenTogetherSession5.f437188e, listenTogetherSession5.f437189f, "music_tab", "clk_member");
                return;
            }
            if (id5 != R.id.lfu) {
                if (id5 == R.id.head) {
                    ListenTogetherSession listenTogetherSession6 = this.f240952c0;
                    String str = listenTogetherSession6.f437189f;
                    r6 = listenTogetherSession6.f437188e == 1 ? 1 : 0;
                    FileBrowserMiniAIOHelper fileBrowserMiniAIOHelper = this.X;
                    if (fileBrowserMiniAIOHelper != null) {
                        fileBrowserMiniAIOHelper.d();
                    }
                    MiniChatActivity.Q2(getBaseActivity(), r6, str, ac.R(this.f240950a0, str, r6));
                    return;
                }
                return;
            }
            if (com.tencent.mobileqq.musicgene.e.a(getBaseActivity(), QZoneHelper.PACKAGENAME_QQMUSIC)) {
                Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse("qqmusic://qq.com/ui/myTab?p=%7B%22tab%22%3A%22home%22%7D&source=https%3A%2F%2Fy.qq.com%2Fm%2Findex.html%3FADTAG%3DYIQITING"));
                intent.putExtra("big_brother_source_key", "biz_src_qqmusic");
                getBaseActivity().startActivity(intent);
                ListenTogetherSession listenTogetherSession7 = this.f240952c0;
                yh(listenTogetherSession7.f437188e, listenTogetherSession7.f437189f, "music_tab", "clk_openmusic");
                return;
            }
            if (!isNetworkAvailable) {
                QQToast.makeText(getBaseActivity(), 1, getBaseActivity().getString(R.string.f171155cp4), 0).show();
                return;
            }
            startActivity(new Intent(getActivity(), (Class<?>) QQBrowserActivity.class).putExtra("url", "https://y.qq.com/m/download/index.html"));
            ListenTogetherSession listenTogetherSession8 = this.f240952c0;
            yh(listenTogetherSession8.f437188e, listenTogetherSession8.f437189f, "music_tab", "clk_downloadmusic");
            return;
        }
        if (!wh()) {
            QQToast.makeText(getBaseActivity(), HardCodeUtil.qqStr(R.string.nq7), 1).show();
            return;
        }
        if (!isNetworkAvailable) {
            QQToast.makeText(getBaseActivity(), 1, getBaseActivity().getString(R.string.f171155cp4), 0).show();
            return;
        }
        int i17 = this.f240952c0.f437191i;
        if (i17 != 1) {
            if (i17 == 2) {
                ListenTogetherManager J4 = ListenTogetherManager.J(this.f240950a0);
                ListenTogetherSession listenTogetherSession9 = this.f240952c0;
                J4.q1(listenTogetherSession9.f437188e, listenTogetherSession9.f437189f);
                this.f240952c0.f437191i = 1;
            }
            if (r6 == 0) {
                Lh(this.f240951b0.getId(), this.f240952c0.f437191i, this.f240955f0);
                return;
            }
            return;
        }
        ListenTogetherManager J5 = ListenTogetherManager.J(this.f240950a0);
        ListenTogetherSession listenTogetherSession10 = this.f240952c0;
        J5.o1(listenTogetherSession10.f437188e, listenTogetherSession10.f437189f);
        this.f240952c0.f437191i = 2;
        r6 = 1;
        if (r6 == 0) {
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        vh();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f240950a0 = getBaseActivity().app;
        View inflate = layoutInflater.inflate(R.layout.cb7, viewGroup, false);
        super.onCreateView(layoutInflater, viewGroup, bundle);
        if (!zh()) {
            getBaseActivity().finish();
            return inflate;
        }
        inflate.setClickable(true);
        Ah(inflate);
        init();
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QQAppInterface qQAppInterface;
        super.onDestroy();
        QQAppInterface qQAppInterface2 = this.f240950a0;
        if (qQAppInterface2 != null) {
            qQAppInterface2.removeObserver(this.f240957h0);
        }
        LyricViewController lyricViewController = this.R;
        if (lyricViewController != null) {
            lyricViewController.m();
        }
        if (this.f240954e0 && (qQAppInterface = this.f240950a0) != null) {
            ListenTogetherManager.J(qQAppInterface).T().U(false);
            this.f240954e0 = false;
        }
        FileBrowserMiniAIOHelper fileBrowserMiniAIOHelper = this.X;
        if (fileBrowserMiniAIOHelper != null) {
            fileBrowserMiniAIOHelper.c();
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        getBaseActivity().overridePendingTransition(R.anim.f154442w, R.anim.f154458a7);
        if (this.f240954e0) {
            ListenTogetherManager.J(this.f240950a0).T().U(false);
            this.f240954e0 = false;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        FileBrowserMiniAIOHelper fileBrowserMiniAIOHelper = this.X;
        if (fileBrowserMiniAIOHelper != null) {
            fileBrowserMiniAIOHelper.e();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        boolean b16 = com.tencent.mobileqq.musicgene.e.b(getBaseActivity());
        boolean z16 = !b16;
        Object tag = this.H.getTag();
        if (tag instanceof Boolean) {
            z16 = ((Boolean) tag).booleanValue();
        }
        if (z16 != b16) {
            this.H.setText(HardCodeUtil.qqStr(b16 ? R.string.nq5 : R.string.nq8));
            this.H.setTag(Boolean.valueOf(b16));
        }
        FileBrowserMiniAIOHelper fileBrowserMiniAIOHelper = this.X;
        if (fileBrowserMiniAIOHelper != null) {
            fileBrowserMiniAIOHelper.f();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Dh(view);
    }

    private void yh(int i3, String str, String str2, String str3) {
        ReportController.o(null, "dc00899", Ch(i3), "", str2, str3, 0, 0, str, "", "", "");
    }

    public static void Hh(Context context, ListenTogetherSession listenTogetherSession, ISong iSong, boolean z16, Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra(SessionDbHelper.SESSION_ID, listenTogetherSession);
        intent.putExtra("song", iSong);
        intent.putExtra("isAdmin", z16);
        PublicFragmentActivity.b.a(context, intent, PublicFragmentActivity.class, ListenTogetherPlayFragment.class);
    }

    private void Ah(View view) {
        this.F = (TextView) view.findViewById(R.id.m97);
        this.G = (TextView) view.findViewById(R.id.iz8);
        this.K = (ImageView) view.findViewById(R.id.lzo);
        this.Q = (LyricViewDetail) view.findViewById(R.id.lrp);
        this.S = (URLImageView) view.findViewById(R.id.f3w);
        this.T = (ImageView) view.findViewById(R.id.f3n);
        this.U = (ImageView) view.findViewById(R.id.f3m);
        this.E = view.findViewById(R.id.f165811lm3);
        this.C = view.findViewById(R.id.if5);
        this.J = (TextView) view.findViewById(R.id.f166995mb1);
        this.I = view.findViewById(R.id.mau);
        this.P = view.findViewById(R.id.lqs);
        this.L = (ImageView) view.findViewById(R.id.lzn);
        this.M = (ImageView) view.findViewById(R.id.lzk);
        this.N = (ImageView) view.findViewById(R.id.lzj);
        this.D = view.findViewById(R.id.f3l);
        for (int i3 = 0; i3 < 5; i3++) {
            this.V[i3] = (ImageView) this.I.findViewWithTag("head" + i3);
        }
        this.H = (TextView) view.findViewById(R.id.lfu);
        ((ViewGroup.MarginLayoutParams) this.U.getLayoutParams()).topMargin = BaseAIOUtils.f(31.0f, getResources());
        this.U.setImageResource(R.drawable.hud);
        this.U.setBackgroundResource(R.drawable.f160334fr);
        xh(this.U.getBackground(), CellDynamicAlbum.sBtnBackgroundColor);
        if (!wh()) {
            this.K.setAlpha(0.2f);
            this.L.setVisibility(4);
            this.N.setVisibility(4);
            this.M.setVisibility(4);
        }
        this.K.setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.U.setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.K.setOnTouchListener(this.f240958i0);
        this.L.setOnTouchListener(this.f240958i0);
        this.N.setOnTouchListener(this.f240958i0);
        this.M.setOnTouchListener(this.f240958i0);
        this.U.setOnTouchListener(this.f240958i0);
        this.H.setOnTouchListener(this.f240958i0);
        this.I.setOnTouchListener(this.f240958i0);
        this.R = new LyricViewController(this.Q);
        if (ScreenUtil.SCREEN_WIDTH > 0) {
            this.D.getLayoutParams().height = ScreenUtil.SCREEN_WIDTH;
        }
        vh();
    }

    private String Ch(int i3) {
        if (i3 == 1) {
            return "Grp_AIO";
        }
        if (i3 == 2) {
            return "c2c_AIO";
        }
        return "";
    }

    private void Dh(View view) {
        AvatarLayout avatarLayout = (AvatarLayout) view.findViewById(R.id.head);
        this.W = avatarLayout;
        avatarLayout.setOnTouchListener(this.f240958i0);
        AccessibilityUtil.c(this.W, getContext().getString(R.string.f172662r2), Button.class.getName());
        View findViewById = view.findViewById(R.id.f165675d35);
        findViewById.setVisibility(0);
        ((ViewGroup.MarginLayoutParams) findViewById.getLayoutParams()).topMargin = BaseAIOUtils.f(28.0f, getResources());
        Drawable defaultFaceDrawable = BaseImageUtil.getDefaultFaceDrawable(true);
        ListenTogetherSession listenTogetherSession = this.f240952c0;
        FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(this.f240950a0, listenTogetherSession.f437188e != 2 ? 4 : 1, listenTogetherSession.f437189f, 4, defaultFaceDrawable, defaultFaceDrawable);
        DynamicAvatarView dynamicAvatarView = (DynamicAvatarView) this.W.findViewById(R.id.a6e);
        dynamicAvatarView.setImageDrawable(faceDrawable);
        int f16 = BaseAIOUtils.f(1.5f, getResources());
        dynamicAvatarView.setPadding(f16, f16, f16, f16);
        dynamicAvatarView.setBackgroundResource(R.drawable.f160334fr);
        ImageView imageView = (ImageView) ((View) this.W.getParent()).findViewById(R.id.d3q);
        FileBrowserMiniAIOHelper fileBrowserMiniAIOHelper = new FileBrowserMiniAIOHelper(this.f240950a0, this.f240952c0.f437189f);
        this.X = fileBrowserMiniAIOHelper;
        fileBrowserMiniAIOHelper.b(imageView);
        this.W.d(0, dynamicAvatarView, false);
        this.W.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kh(List<String> list, String str) {
        int size = list == null ? 0 : list.size();
        for (int i3 = 0; i3 < 5; i3++) {
            if (i3 < size) {
                this.V[i3].setVisibility(0);
                Ih(list.get(i3), this.V[i3]);
            } else {
                this.V[i3].setVisibility(8);
                this.V[i3].setImageDrawable(null);
            }
        }
        if (this.f240952c0.f437188e == 1) {
            this.I.setClickable(true);
            this.I.setOnTouchListener(this.f240958i0);
        } else {
            this.I.setClickable(true);
            this.I.setOnTouchListener(null);
        }
        this.J.setText(str);
    }
}
