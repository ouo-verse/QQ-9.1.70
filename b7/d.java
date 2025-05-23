package b7;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.homepage.diy.ScrollTextView;
import com.qzone.personalize.music.model.UserMusicInfo;
import com.qzone.personalize.music.ui.MiniMusicPlayerDIYBar;
import com.qzone.personalize.music.ui.MusicPlayerDIYBar;
import com.qzone.widget.AsyncImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.music.BroadcastMusicInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import cooperation.qzone.util.QZLog;
import cooperation.vip.manager.MonitorManager;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private View f28025a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f28026a;

        /* renamed from: b, reason: collision with root package name */
        public String f28027b;

        /* renamed from: c, reason: collision with root package name */
        public String f28028c;

        /* renamed from: d, reason: collision with root package name */
        public String f28029d;

        /* renamed from: e, reason: collision with root package name */
        public String f28030e;

        /* renamed from: f, reason: collision with root package name */
        public String f28031f;

        /* renamed from: g, reason: collision with root package name */
        public String f28032g;

        a() {
        }

        public static a a(String str) {
            try {
                a aVar = new a();
                JSONObject jSONObject = new JSONObject(str);
                aVar.f28026a = jSONObject.optString("player_text_color_main");
                aVar.f28027b = jSONObject.optString("player_text_color_second");
                aVar.f28028c = jSONObject.optString("player_background_image");
                aVar.f28029d = jSONObject.optString("player_cover_image");
                aVar.f28030e = jSONObject.optString("player_play_image");
                aVar.f28031f = jSONObject.optString("player_pause_image");
                aVar.f28032g = jSONObject.optString("player_cover_background");
                aVar.f28026a = com.qzone.homepage.diy.util.a.c(aVar.f28026a, "#A3ffffff");
                aVar.f28027b = com.qzone.homepage.diy.util.a.c(aVar.f28027b, TipsElementData.DEFAULT_COLOR);
                return aVar;
            } catch (JSONException e16) {
                MonitorManager.f().h(24, 4, "parse player json error = " + str, false);
                e16.printStackTrace();
                return null;
            }
        }
    }

    public d(Context context) {
        this.f28025a = e8.f.a().c().g(context, LoginData.getInstance().getUin(), 2);
    }

    public View a() {
        return this.f28025a;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class b extends g<a> {
        private RelativeLayout E;
        private AsyncImageView F;
        private AsyncImageView G;
        private TextView H;
        private TextView I;
        public String J;
        public String K;
        private View L;
        private MiniMusicPlayerDIYBar M;
        private RelativeLayout N;
        private AsyncImageView P;
        private AsyncImageView Q;

        public b(String str, View view) {
            super(str, view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // b7.g
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public a w(String str) {
            return a.a(str);
        }

        public void D() {
            MiniMusicPlayerDIYBar miniMusicPlayerDIYBar = this.M;
            if (miniMusicPlayerDIYBar != null) {
                miniMusicPlayerDIYBar.V();
            }
        }

        @Override // e15.f, android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Object obj;
            if (message.what == 1 && (obj = message.obj) != null && (obj instanceof Drawable)) {
                this.E.setBackgroundDrawable((Drawable) obj);
            }
            return super.handleMessage(message);
        }

        @Override // e15.f
        public void l() {
            super.l();
            TextView textView = this.I;
            if (textView == null || !(textView instanceof ScrollTextView)) {
                return;
            }
            ((ScrollTextView) textView).g();
        }

        @Override // e15.f
        public void n() {
            super.n();
            TextView textView = this.I;
            if (textView == null || !(textView instanceof ScrollTextView)) {
                return;
            }
            ((ScrollTextView) textView).h();
        }

        @Override // e15.f
        public void o() {
            super.o();
            TextView textView = this.I;
            if (textView == null || !(textView instanceof ScrollTextView)) {
                return;
            }
            ((ScrollTextView) textView).i();
        }

        @Override // e15.f
        public void p() {
            ViewGroup.LayoutParams layoutParams;
            super.p();
            View view = this.f395367e;
            if (view == null || (layoutParams = view.getLayoutParams()) == null) {
                return;
            }
            layoutParams.width = ViewUtils.dip2px(132.0f);
            layoutParams.height = ViewUtils.dip2px(48.0f);
            this.f395367e.setLayoutParams(layoutParams);
        }

        @Override // b7.g
        String u() {
            return "content";
        }

        @Override // b7.g
        void v() {
            View view = this.f395367e;
            this.L = view;
            this.E = (RelativeLayout) view.findViewById(R.id.gu8);
            this.F = (AsyncImageView) this.L.findViewById(R.id.fvg);
            this.G = (AsyncImageView) this.L.findViewById(R.id.fve);
            this.H = (TextView) this.L.findViewById(R.id.fvi);
            this.I = (TextView) this.L.findViewById(R.id.f166643gu2);
            MiniMusicPlayerDIYBar miniMusicPlayerDIYBar = new MiniMusicPlayerDIYBar(this.f395367e.getContext(), LoginData.getInstance().getUin());
            this.M = miniMusicPlayerDIYBar;
            this.N = (RelativeLayout) miniMusicPlayerDIYBar.findViewById(R.id.gu8);
            this.P = (AsyncImageView) this.M.findViewById(R.id.fvg);
            this.Q = (AsyncImageView) this.M.findViewById(R.id.fve);
            this.M.setBackgroundDrawable(null);
            this.L.setVisibility(8);
            this.M.setVisibility(8);
        }

        @Override // b7.g
        public void z(long j3, x6.a aVar) {
            super.z(j3, aVar);
            E(aVar, this.L);
            E(aVar, this.M);
        }

        public void B(ViewGroup viewGroup) {
            MiniMusicPlayerDIYBar miniMusicPlayerDIYBar;
            if (viewGroup == null || (miniMusicPlayerDIYBar = this.M) == null) {
                return;
            }
            if (miniMusicPlayerDIYBar.getParent() == null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(ViewUtils.dip2px(48.0f), ViewUtils.dip2px(48.0f));
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.L.getLayoutParams();
                if (marginLayoutParams2 != null) {
                    this.M.setInitLocation(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin);
                }
                this.M.setLayoutParams(marginLayoutParams);
                viewGroup.addView(this.M);
                return;
            }
            QZLog.i("JsonInflateViewModel", 4, " header music has parent");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // b7.g
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public void A(a aVar) {
            if (aVar != null) {
                if (!TextUtils.isEmpty(aVar.f28032g)) {
                    this.F.setAsyncImage(aVar.f28032g);
                    this.P.setAsyncImage(aVar.f28032g);
                }
                if (!TextUtils.isEmpty(aVar.f28029d)) {
                    this.G.setAsyncImage(aVar.f28029d);
                    this.Q.setAsyncImage(aVar.f28029d);
                }
                String str = aVar.f28031f;
                this.J = str;
                String str2 = aVar.f28030e;
                this.K = str2;
                View view = this.L;
                if (view instanceof MusicPlayerDIYBar) {
                    ((MusicPlayerDIYBar) view).setPlayIconUrl(str2, str);
                }
                MiniMusicPlayerDIYBar miniMusicPlayerDIYBar = this.M;
                if (miniMusicPlayerDIYBar instanceof MusicPlayerDIYBar) {
                    miniMusicPlayerDIYBar.setPlayIconUrl(this.K, this.J);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x00b3  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void E(x6.a aVar, View view) {
            if (view == null || aVar == null) {
                return;
            }
            int i3 = aVar.relationShip;
            boolean z16 = true;
            if ((i3 == 0 || i3 == 1 || i3 == 2) && !aVar.isCertification && !aVar.isSchoolSpaceUser() && !aVar.isStarSpaceUser() && !aVar.isOld52SpaceUser() && !aVar.isVideo57SpaceUser()) {
                int i16 = aVar.bgVoiceType;
                if (2 == i16) {
                    ArrayList<BroadcastMusicInfo> arrayList = aVar.allFmBroadCastList;
                    if (arrayList != null && arrayList.size() > 0) {
                        e8.d c16 = e8.f.a().c();
                        ArrayList<BroadcastMusicInfo> arrayList2 = aVar.allFmBroadCastList;
                        c16.a(view, arrayList2, true, arrayList2.size(), aVar.wifiAutoPlayFlag, aVar.playMode, 2, aVar.bgVoiceType, aVar.loopPlaybackType);
                    }
                } else if (1 == i16) {
                    ArrayList<UserMusicInfo> arrayList3 = aVar.allFmList;
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        e8.d c17 = e8.f.a().c();
                        ArrayList<UserMusicInfo> arrayList4 = aVar.allFmList;
                        c17.h(view, arrayList4, true, arrayList4.size(), aVar.wifiAutoPlayFlag, aVar.playMode, 2, aVar.bgVoiceType, aVar.loopPlaybackType);
                    }
                } else {
                    ArrayList<UserMusicInfo> arrayList5 = aVar.allMusicList;
                    if (arrayList5 != null && arrayList5.size() > 0) {
                        e8.f.a().c().h(view, aVar.allMusicList, aVar.musicCanPlay, aVar.allMusicNums, aVar.wifiAutoPlayFlag, aVar.playMode, 2, aVar.bgVoiceType, aVar.loopPlaybackType);
                    }
                }
                view.setVisibility(z16 ? 0 : 8);
            }
            z16 = false;
            view.setVisibility(z16 ? 0 : 8);
        }
    }
}
