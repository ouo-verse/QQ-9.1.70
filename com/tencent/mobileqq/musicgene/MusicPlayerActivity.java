package com.tencent.mobileqq.musicgene;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.lyric.widget.LyricViewController;
import com.tencent.mobileqq.lyric.widget.LyricViewDetail;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.music.c;
import com.tencent.mobileqq.music.e;
import com.tencent.mobileqq.musicgene.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.i;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.protofile.getappinfo.GetAppInfoProto$AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto$GetAppinfoResponse;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetAdapter;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* loaded from: classes15.dex */
public class MusicPlayerActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: s0, reason: collision with root package name */
    private static final HashMap<String, Long> f251900s0;

    /* renamed from: t0, reason: collision with root package name */
    private static final HashMap<String, String> f251901t0;

    /* renamed from: u0, reason: collision with root package name */
    private static final HashMap<String, h> f251902u0;

    /* renamed from: a0, reason: collision with root package name */
    private com.tencent.mobileqq.music.e f251903a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f251904b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f251905c0;

    /* renamed from: d0, reason: collision with root package name */
    private ImageView f251906d0;

    /* renamed from: e0, reason: collision with root package name */
    private ImageView f251907e0;

    /* renamed from: f0, reason: collision with root package name */
    private ImageView f251908f0;

    /* renamed from: g0, reason: collision with root package name */
    private ImageView f251909g0;

    /* renamed from: h0, reason: collision with root package name */
    private MusicPlayerHandler f251910h0;

    /* renamed from: i0, reason: collision with root package name */
    private final f f251911i0;

    /* renamed from: j0, reason: collision with root package name */
    private View.OnClickListener f251912j0;

    /* renamed from: k0, reason: collision with root package name */
    private final ServiceConnection f251913k0;

    /* renamed from: l0, reason: collision with root package name */
    private final c.a f251914l0;

    /* renamed from: m0, reason: collision with root package name */
    private a.InterfaceC8126a f251915m0;

    /* renamed from: n0, reason: collision with root package name */
    private final e f251916n0;

    /* renamed from: o0, reason: collision with root package name */
    private LyricViewController f251917o0;

    /* renamed from: p0, reason: collision with root package name */
    private com.tencent.mobileqq.lyric.data.b f251918p0;

    /* renamed from: q0, reason: collision with root package name */
    private com.tencent.mobileqq.lyric.data.b f251919q0;

    /* renamed from: r0, reason: collision with root package name */
    LyricViewDetail f251920r0;

    /* renamed from: com.tencent.mobileqq.musicgene.MusicPlayerActivity$1, reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass1 implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private ActionSheet f251921d;

        AnonymousClass1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MusicPlayerActivity.this);
            } else {
                this.f251921d = null;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:62:0x01cf A[Catch: RemoteException -> 0x02ed, TryCatch #0 {RemoteException -> 0x02ed, blocks: (B:47:0x01a6, B:50:0x01ae, B:52:0x01b4, B:54:0x01b7, B:56:0x01bd, B:60:0x01c5, B:62:0x01cf, B:64:0x01d4, B:66:0x01e4, B:67:0x01c3, B:68:0x01fd, B:69:0x0202), top: B:46:0x01a6 }] */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            String token;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                com.tencent.mobileqq.music.e eVar = MusicPlayerActivity.this.f251903a0;
                int id5 = view.getId();
                if (id5 == R.id.f3m) {
                    MusicPlayerActivity.this.finish();
                } else {
                    int i3 = 0;
                    if (id5 == R.id.f3u) {
                        ReportController.o(MusicPlayerActivity.this.app, "CliOper", "", "", "0X800682A", "0X800682A", 0, 0, "", "", "", "");
                        Object tag = view.getTag();
                        Context context = view.getContext();
                        if ((tag instanceof g) && context != null) {
                            g gVar = (g) tag;
                            ArrayList arrayList = new ArrayList();
                            while (i3 <= 3) {
                                arrayList.add(ActionSheetAdapter.createShareDefaultChanelInfo(i3));
                                i3++;
                            }
                            ActionSheetAdapter actionSheetAdapter = new ActionSheetAdapter(context);
                            actionSheetAdapter.setData(arrayList);
                            ActionSheet createShareActionSheet = ActionSheetAdapter.createShareActionSheet(context, actionSheetAdapter, new AdapterView.OnItemClickListener(gVar) { // from class: com.tencent.mobileqq.musicgene.MusicPlayerActivity.1.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ g f251923d;

                                {
                                    this.f251923d = gVar;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) gVar);
                                    }
                                }

                                @Override // android.widget.AdapterView.OnItemClickListener
                                public void onItemClick(AdapterView<?> adapterView, View view2, int i16, long j3) {
                                    EventCollector.getInstance().onItemClickBefore(adapterView, view2, i16, j3);
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, this, adapterView, view2, Integer.valueOf(i16), Long.valueOf(j3));
                                    } else {
                                        if (i16 != 0) {
                                            if (i16 != 1) {
                                                if (i16 == 2 || i16 == 3) {
                                                    ThreadManagerV2.post(new Runnable(i16) { // from class: com.tencent.mobileqq.musicgene.MusicPlayerActivity.1.1.1
                                                        static IPatchRedirector $redirector_;

                                                        /* renamed from: d, reason: collision with root package name */
                                                        final /* synthetic */ int f251925d;

                                                        {
                                                            this.f251925d = i16;
                                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) C81241.this, i16);
                                                            }
                                                        }

                                                        @Override // java.lang.Runnable
                                                        public void run() {
                                                            int width;
                                                            int height;
                                                            int width2;
                                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                                                return;
                                                            }
                                                            Bitmap I = MusicGeneWebViewPlugin.I(C81241.this.f251923d.f251936c);
                                                            if (I != null && (width2 = (width = I.getWidth()) * (height = I.getHeight())) > 8000) {
                                                                double sqrt = Math.sqrt(8000.0d / width2);
                                                                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(I, (int) (width * sqrt), (int) (height * sqrt), true);
                                                                I.recycle();
                                                                Message obtain = Message.obtain(MusicPlayerActivity.this.f251916n0, 55);
                                                                obtain.arg1 = this.f251925d;
                                                                obtain.obj = createScaledBitmap;
                                                                obtain.sendToTarget();
                                                            }
                                                        }
                                                    }, 8, null, true);
                                                }
                                            } else {
                                                MusicPlayerActivity musicPlayerActivity = MusicPlayerActivity.this;
                                                g gVar2 = this.f251923d;
                                                musicPlayerActivity.r3(gVar2.f251934a, gVar2.f251935b, gVar2.f251937d, gVar2.f251936c, gVar2.f251938e);
                                            }
                                        } else {
                                            MusicPlayerActivity musicPlayerActivity2 = MusicPlayerActivity.this;
                                            g gVar3 = this.f251923d;
                                            musicPlayerActivity2.p3(gVar3.f251934a, gVar3.f251935b, gVar3.f251937d, gVar3.f251936c, gVar3.f251938e);
                                        }
                                        AnonymousClass1.this.f251921d.dismiss();
                                    }
                                    EventCollector.getInstance().onItemClick(adapterView, view2, i16, j3);
                                }
                            }, null, null, true);
                            this.f251921d = createShareActionSheet;
                            createShareActionSheet.show();
                        }
                    } else if (id5 == R.id.f3r) {
                        if (eVar != null) {
                            String e16 = ah.e();
                            try {
                                SongInfo currentSong = eVar.getCurrentSong();
                                if (currentSong != null) {
                                    String f36 = MusicPlayerActivity.this.f3(currentSong);
                                    if (MusicPlayerActivity.f251900s0.containsKey(f36)) {
                                        Object tag2 = view.getTag();
                                        if (view.isSelected()) {
                                            ReportController.o(MusicPlayerActivity.this.app, "CliOper", "", "", "0X8006829", "0X8006829", 0, 0, "", "", "", "");
                                            MusicPlayerActivity.this.f251910h0.F2(e16, MusicPlayerActivity.this.app.getLongAccountUin(), ((Long) MusicPlayerActivity.f251900s0.get(f36)).longValue(), false);
                                            view.setSelected(false);
                                            MusicPlayerActivity.this.f251907e0.setImageResource(R.drawable.d1y);
                                            if (tag2 instanceof Integer) {
                                                MusicPlayerActivity.this.n3(R.drawable.d1y, ((Integer) tag2).intValue());
                                            }
                                        } else {
                                            ReportController.o(MusicPlayerActivity.this.app, "CliOper", "", "", "0X8006828", "0X8006828", 0, 0, "", "", "", "");
                                            MusicPlayerActivity.this.f251910h0.F2(e16, MusicPlayerActivity.this.app.getLongAccountUin(), ((Long) MusicPlayerActivity.f251900s0.get(f36)).longValue(), true);
                                            view.setSelected(true);
                                            MusicPlayerActivity.this.f251907e0.setImageResource(R.drawable.d1x);
                                            if (tag2 instanceof Integer) {
                                                MusicPlayerActivity.this.n3(R.drawable.d1x, ((Integer) tag2).intValue());
                                            }
                                        }
                                    }
                                }
                            } catch (RemoteException e17) {
                                QLog.e("MusicPlayerActivity", 1, "add favourite RemoteException ", e17);
                            }
                        }
                    } else {
                        SongInfo songInfo = null;
                        if (id5 == R.id.f3t) {
                            if (eVar != null) {
                                try {
                                    int playState = eVar.getPlayState();
                                    if (playState != 2) {
                                        if (playState != 3) {
                                            SongInfo[] B2 = eVar.B2();
                                            if (B2 != null && B2.length > 0) {
                                                int w3 = eVar.w3();
                                                if (w3 >= 0 && w3 < B2.length) {
                                                    i3 = w3;
                                                    token = eVar.getToken();
                                                    if (!TextUtils.isEmpty(token)) {
                                                        eVar.b2(token, B2, i3);
                                                        if (songInfo != null) {
                                                            String f37 = MusicPlayerActivity.this.f3(songInfo);
                                                            if (MusicPlayerActivity.f251902u0.containsKey(f37)) {
                                                                h hVar = (h) MusicPlayerActivity.f251902u0.get(f37);
                                                                MusicPlayerActivity.this.j3(hVar, MusicPlayerActivity.this.h3(eVar, songInfo, hVar.f251940a));
                                                            }
                                                        }
                                                    }
                                                }
                                                songInfo = B2[0];
                                                token = eVar.getToken();
                                                if (!TextUtils.isEmpty(token)) {
                                                }
                                            }
                                        } else {
                                            eVar.resume();
                                        }
                                    } else {
                                        eVar.pause();
                                    }
                                } catch (RemoteException unused) {
                                }
                            }
                        } else if (id5 == R.id.f3o) {
                            ReportController.o(MusicPlayerActivity.this.app, "CliOper", "", "", "0X800682B", "0X800682B", 0, 0, "", "", "", "");
                            if (com.tencent.mobileqq.musicgene.e.a(MusicPlayerActivity.this, QZoneHelper.PACKAGENAME_QQMUSIC)) {
                                if (eVar != null) {
                                    try {
                                        songInfo = eVar.getCurrentSong();
                                    } catch (RemoteException e18) {
                                        QLog.e("MusicPlayerActivity", 1, "music player activity RemoteException ", e18);
                                    }
                                }
                                if (songInfo != null) {
                                    String f38 = MusicPlayerActivity.this.f3(songInfo);
                                    if (MusicPlayerActivity.f251900s0.containsKey(f38)) {
                                        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(String.format("androidqqmusic://form=webpage&mid=23&k1=0&k2=%s&download=1&action=download", String.valueOf(MusicPlayerActivity.f251900s0.get(f38)))));
                                        intent.putExtra("big_brother_source_key", "biz_src_qqmusic");
                                        MusicPlayerActivity.this.startActivity(intent);
                                        ReportController.o(MusicPlayerActivity.this.app, "CliOper", "", "", "0X800682C", "0X800682C", 0, 0, "", "", "", "");
                                    }
                                }
                            } else if (!NetworkUtil.isNetworkAvailable(MusicPlayerActivity.this.getApplicationContext())) {
                                MusicPlayerActivity musicPlayerActivity = MusicPlayerActivity.this;
                                QQToast.makeText(musicPlayerActivity, 1, musicPlayerActivity.getString(R.string.f171155cp4), 0).show();
                            } else {
                                MusicPlayerActivity.this.startActivity(new Intent(MusicPlayerActivity.this.getActivity(), (Class<?>) QQBrowserActivity.class).putExtra("url", "https://y.qq.com/m/download/index.html"));
                            }
                        }
                    }
                }
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes15.dex */
    class a implements ServiceConnection {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MusicPlayerActivity.this);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                return;
            }
            MusicPlayerActivity.this.f251903a0 = e.a.j(iBinder);
            try {
                MusicPlayerActivity.this.f251903a0.C4(MusicPlayerActivity.this.f251914l0);
                SongInfo currentSong = MusicPlayerActivity.this.f251903a0.getCurrentSong();
                MusicPlayerActivity musicPlayerActivity = MusicPlayerActivity.this;
                String h36 = musicPlayerActivity.h3(musicPlayerActivity.f251903a0, currentSong, -1L);
                if (currentSong != null) {
                    String f36 = MusicPlayerActivity.this.f3(currentSong);
                    if (MusicPlayerActivity.f251902u0.containsKey(f36)) {
                        MusicPlayerActivity.this.j3((h) MusicPlayerActivity.f251902u0.get(f36), h36);
                    } else {
                        MusicPlayerActivity.this.l3(currentSong.f251871i, currentSong.F, currentSong.C, h36, false, false);
                    }
                    Message.obtain(MusicPlayerActivity.this.f251916n0, 50, MusicPlayerActivity.this.f251903a0.getPlayState(), 0).sendToTarget();
                    MusicPlayerActivity.this.f251910h0.G2(MusicPlayerActivity.this.app.getLongAccountUin(), currentSong.f251871i, currentSong.F, currentSong.E, String.valueOf(currentSong.f251867d), currentSong.f251872m, MusicPlayerActivity.this.f251903a0.getDuration());
                }
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                com.tencent.mobileqq.music.e eVar = MusicPlayerActivity.this.f251903a0;
                if (eVar != null) {
                    try {
                        eVar.X3(MusicPlayerActivity.this.f251914l0);
                        return;
                    } catch (RemoteException unused) {
                        return;
                    }
                }
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
        }
    }

    /* loaded from: classes15.dex */
    class b extends c.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MusicPlayerActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.music.c
        public void onPlaySongChanged(SongInfo songInfo) throws RemoteException {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) songInfo);
                return;
            }
            if (songInfo != null) {
                String f36 = MusicPlayerActivity.this.f3(songInfo);
                if (MusicPlayerActivity.f251902u0.containsKey(f36)) {
                    h hVar = (h) MusicPlayerActivity.f251902u0.get(f36);
                    MusicPlayerActivity musicPlayerActivity = MusicPlayerActivity.this;
                    MusicPlayerActivity.this.j3(hVar, musicPlayerActivity.h3(musicPlayerActivity.f251903a0, songInfo, hVar.f251940a));
                    return;
                }
                if (!MusicPlayerActivity.f251900s0.containsKey(f36)) {
                    com.tencent.mobileqq.music.e eVar = MusicPlayerActivity.this.f251903a0;
                    if (eVar != null) {
                        i3 = eVar.getDuration();
                    } else {
                        i3 = 0;
                    }
                    int i16 = i3;
                    MusicPlayerActivity musicPlayerActivity2 = MusicPlayerActivity.this;
                    MusicPlayerActivity.this.l3(songInfo.f251871i, songInfo.F, songInfo.C, musicPlayerActivity2.h3(musicPlayerActivity2.f251903a0, songInfo, -1L), false, false);
                    MusicPlayerActivity.this.f251910h0.G2(MusicPlayerActivity.this.app.getLongAccountUin(), songInfo.f251871i, songInfo.F, songInfo.E, String.valueOf(songInfo.f251867d), songInfo.f251872m, i16);
                }
            }
        }

        @Override // com.tencent.mobileqq.music.c
        public void onPlayStateChanged(int i3) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                Message.obtain(MusicPlayerActivity.this.f251916n0, 50, i3, 0).sendToTarget();
            }
        }
    }

    /* loaded from: classes15.dex */
    class c implements a.InterfaceC8126a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MusicPlayerActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.musicgene.a.InterfaceC8126a
        public void a(String str, int i3, int i16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), obj);
                return;
            }
            Message obtain = Message.obtain(MusicPlayerActivity.this.f251916n0, 49);
            Bundle bundle = new Bundle();
            bundle.putIntArray("KEY_COLOR_LIST", new int[]{i3, i16});
            bundle.putBoolean("KEY_MATCH_SONG", ((Boolean) obj).booleanValue());
            obtain.setData(bundle);
            obtain.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class d implements com.tencent.open.appcommon.d {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Intent f251930d;

        d(Intent intent) {
            this.f251930d = intent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MusicPlayerActivity.this, (Object) intent);
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            GetAppInfoProto$AndroidInfo getAppInfoProto$AndroidInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            if (z16) {
                try {
                    byte[] byteArray = bundle.getByteArray("data");
                    if (byteArray != null) {
                        GetAppInfoProto$GetAppinfoResponse getAppInfoProto$GetAppinfoResponse = new GetAppInfoProto$GetAppinfoResponse();
                        getAppInfoProto$GetAppinfoResponse.mergeFrom(byteArray);
                        if (getAppInfoProto$GetAppinfoResponse.has() && getAppInfoProto$GetAppinfoResponse.ret.get() == 0 && (getAppInfoProto$AndroidInfo = getAppInfoProto$GetAppinfoResponse.androidInfo) != null) {
                            String k3 = Share.k(getAppInfoProto$GetAppinfoResponse.iconsURL, 16);
                            this.f251930d.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL, getAppInfoProto$AndroidInfo.sourceUrl.get());
                            Intent intent = this.f251930d;
                            if (k3 == null) {
                                k3 = "";
                            }
                            intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, k3);
                            this.f251930d.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_NAME, getAppInfoProto$AndroidInfo.messagetail.get());
                            this.f251930d.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_A_ACTION_DATA, getAppInfoProto$AndroidInfo.packName.get());
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MusicPlayerActivity", 2, e16.getMessage());
                    }
                }
            }
            AbsStructMsg e17 = i.e(this.f251930d.getExtras());
            if (e17 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("MusicPlayerActivity", 2, "build struct msg fail");
                }
            } else {
                this.f251930d.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, e17.getBytes());
                MusicPlayerActivity.this.startActivityForResult(this.f251930d, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class e extends Handler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<MusicPlayerActivity> f251932a;

        public e(MusicPlayerActivity musicPlayerActivity) {
            super(Looper.getMainLooper());
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) musicPlayerActivity);
            } else {
                this.f251932a = new WeakReference<>(musicPlayerActivity);
            }
        }

        private void a(int[] iArr, boolean z16) {
            MusicPlayerActivity musicPlayerActivity = this.f251932a.get();
            if (iArr != null && iArr.length >= 2 && musicPlayerActivity != null) {
                int i3 = iArr[0];
                int argb = Color.argb(0, Color.red(i3), Color.green(i3), Color.blue(i3));
                ((ImageView) musicPlayerActivity.findViewById(R.id.f3n)).setImageDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{i3, argb, argb, argb, argb, argb, i3}));
                musicPlayerActivity.findViewById(R.id.f3q).setBackgroundColor(i3);
                int i16 = iArr[1];
                int argb2 = Color.argb(128, Color.red(i16), Color.green(i16), Color.blue(i16));
                musicPlayerActivity.f251904b0.setTextColor(i16);
                musicPlayerActivity.f251905c0.setTextColor(i16);
                musicPlayerActivity.f251920r0.a().setLyricHilightColor(i16);
                musicPlayerActivity.f251920r0.a().setLyricColor(argb2);
                musicPlayerActivity.f251906d0.setTag(Integer.valueOf(i16));
                musicPlayerActivity.f251907e0.setTag(Integer.valueOf(i16));
                musicPlayerActivity.f251908f0.setTag(Integer.valueOf(i16));
                musicPlayerActivity.n3(R.drawable.d8q, i16);
                musicPlayerActivity.n3(R.drawable.d8r, i16);
                musicPlayerActivity.n3(R.drawable.clt, i16);
                if (z16) {
                    musicPlayerActivity.n3(R.drawable.d1w, i16);
                    musicPlayerActivity.n3(R.drawable.d1y, i16);
                    musicPlayerActivity.n3(R.drawable.d1x, i16);
                    musicPlayerActivity.n3(R.drawable.byu, i16);
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CalloutPopupWindow build;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            MusicPlayerActivity musicPlayerActivity = this.f251932a.get();
            Bundle data = message.getData();
            if (musicPlayerActivity != null) {
                int i16 = 4;
                switch (message.what) {
                    case 49:
                        a(data.getIntArray("KEY_COLOR_LIST"), data.getBoolean("KEY_MATCH_SONG"));
                        return;
                    case 50:
                        int i17 = message.arg1;
                        Object tag = musicPlayerActivity.f251906d0.getTag();
                        if (tag instanceof Integer) {
                            int intValue = ((Integer) tag).intValue();
                            musicPlayerActivity.n3(R.drawable.d8q, intValue);
                            musicPlayerActivity.n3(R.drawable.d8r, intValue);
                        }
                        if (i17 != 3 && i17 != 4) {
                            musicPlayerActivity.f251906d0.setImageResource(R.drawable.d8q);
                        } else {
                            musicPlayerActivity.f251906d0.setImageResource(R.drawable.d8r);
                        }
                        musicPlayerActivity.s3();
                        return;
                    case 51:
                        Object obj = message.obj;
                        if (obj instanceof g) {
                            g gVar = (g) obj;
                            if (message.arg1 == 1) {
                                i16 = 0;
                            }
                            musicPlayerActivity.f251907e0.setVisibility(i16);
                            if (musicPlayerActivity.f251907e0.isSelected()) {
                                musicPlayerActivity.f251907e0.setImageResource(R.drawable.d1x);
                            } else {
                                musicPlayerActivity.f251907e0.setImageResource(R.drawable.d1y);
                            }
                            musicPlayerActivity.f251908f0.setVisibility(i16);
                            musicPlayerActivity.f251908f0.setImageResource(R.drawable.d1w);
                            musicPlayerActivity.f251909g0.setVisibility(i16);
                            musicPlayerActivity.f251909g0.setImageResource(R.drawable.byu);
                            musicPlayerActivity.f251909g0.setTag(gVar);
                            return;
                        }
                        return;
                    case 52:
                        if (data != null) {
                            String string = data.getString("KEY_SONG_NAME");
                            data.getString("KEY_SINGER_NAME");
                            String string2 = data.getString("KEY_IMG_URL");
                            boolean z16 = data.getBoolean("KEY_MATCH_SONG");
                            boolean z17 = data.getBoolean("KEY_IS_FAVOURITE");
                            if (!TextUtils.isEmpty(string)) {
                                musicPlayerActivity.f251904b0.setText(string);
                            }
                            if (z16) {
                                if (z17) {
                                    musicPlayerActivity.f251907e0.setImageResource(R.drawable.d1x);
                                } else {
                                    musicPlayerActivity.f251907e0.setImageResource(R.drawable.d1y);
                                }
                                musicPlayerActivity.f251907e0.setSelected(z17);
                            }
                            if (!TextUtils.isEmpty(string2) && Patterns.WEB_URL.matcher(string2).matches()) {
                                URLImageView uRLImageView = (URLImageView) musicPlayerActivity.findViewById(R.id.f3w);
                                URLDrawable drawable = URLDrawable.getDrawable(string2, URLDrawable.URLDrawableOptions.obtain());
                                List<Integer> a16 = com.tencent.mobileqq.musicgene.a.a(string2);
                                if (a16 != null) {
                                    int[] iArr = new int[a16.size()];
                                    for (int i18 = 0; i18 < a16.size(); i18++) {
                                        iArr[i18] = a16.get(i18).intValue();
                                    }
                                    a(iArr, z16);
                                } else {
                                    com.tencent.mobileqq.musicgene.a aVar = new com.tencent.mobileqq.musicgene.a(string2, musicPlayerActivity.f251915m0, Boolean.valueOf(z16));
                                    if (drawable.getStatus() == 1) {
                                        Drawable currDrawable = drawable.getCurrDrawable();
                                        if (currDrawable instanceof RegionDrawable) {
                                            aVar.run(null, ((RegionDrawable) currDrawable).getBitmap());
                                        }
                                    } else {
                                        drawable.setDecodeHandler(aVar);
                                    }
                                }
                                uRLImageView.setImageDrawable(drawable);
                            }
                            String string3 = data.getString("KEY_SOURCE_NAME");
                            if (TextUtils.isEmpty(string3)) {
                                musicPlayerActivity.f251905c0.setText(R.string.ces);
                                return;
                            } else {
                                musicPlayerActivity.f251905c0.setText(musicPlayerActivity.getString(R.string.ceq, string3));
                                return;
                            }
                        }
                        return;
                    case 53:
                        musicPlayerActivity.s3();
                        return;
                    case 54:
                        Object obj2 = message.obj;
                        if (obj2 instanceof View) {
                            View view = (View) obj2;
                            CalloutPopupWindow.Builder textColor = CalloutPopupWindow.builder(musicPlayerActivity).setLifetime(3).setText(musicPlayerActivity.getString(message.arg1)).setTextColor(message.arg2);
                            textColor.setPosition(49);
                            CalloutPopupWindow.Builder build2 = new CalloutPopupWindow.DrawableBuilder(textColor).setBackgroundColor(Color.argb(13, 255, 255, 255)).setBackgroundRadius(5).build();
                            if (build2 != null && (build = build2.build()) != null) {
                                build.showAsPointer(view);
                                return;
                            }
                            return;
                        }
                        return;
                    case 55:
                        Object tag2 = musicPlayerActivity.f251909g0.getTag();
                        if (tag2 instanceof g) {
                            g gVar2 = (g) tag2;
                            Object obj3 = message.obj;
                            if (obj3 instanceof Bitmap) {
                                Bitmap bitmap = (Bitmap) obj3;
                                String valueOf = String.valueOf(System.currentTimeMillis());
                                if (message.arg1 == 2) {
                                    i3 = 0;
                                } else {
                                    i3 = 1;
                                }
                                WXShareHelper.b0().A0(valueOf, gVar2.f251934a, bitmap, gVar2.f251935b, gVar2.f251937d, i3, gVar2.f251938e);
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes15.dex */
    public static class f implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<MusicPlayerActivity> f251933d;

        public f(MusicPlayerActivity musicPlayerActivity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) musicPlayerActivity);
            } else {
                this.f251933d = new WeakReference<>(musicPlayerActivity);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0147  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x013f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.tencent.mobileqq.app.BusinessObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onUpdate(int i3, boolean z16, Object obj) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            boolean z17;
            String str6;
            com.tencent.mobileqq.music.e eVar;
            SongInfo currentSong;
            int i16;
            int i17;
            String str7 = "";
            IPatchRedirector iPatchRedirector = $redirector_;
            int i18 = 1;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                return;
            }
            MusicPlayerActivity musicPlayerActivity = this.f251933d.get();
            if ((obj instanceof String) && musicPlayerActivity != null) {
                String str8 = (String) obj;
                QLog.d("MusicPlayerActivity", 4, "musicPlayerActivity onUpdate ", String.valueOf(str8));
                switch (i3) {
                    case 81:
                        long j3 = 0;
                        try {
                            JSONObject jSONObject = new JSONObject(str8).getJSONObject("data");
                            str2 = jSONObject.optString("picurl");
                            try {
                                str3 = jSONObject.optString("lyric");
                                try {
                                    str4 = jSONObject.optString("shareurl");
                                    try {
                                        if (jSONObject.has("isfavorite")) {
                                            i16 = jSONObject.getInt("isfavorite");
                                        } else {
                                            i16 = 0;
                                        }
                                        if (i16 == 1) {
                                            z17 = true;
                                        } else {
                                            z17 = false;
                                        }
                                        try {
                                            if (jSONObject.isNull(QzoneWebMusicJsPlugin.EVENT_GET_SONGINFO)) {
                                                str6 = "";
                                                str5 = str6;
                                                i18 = 0;
                                            } else {
                                                JSONObject jSONObject2 = jSONObject.getJSONObject(QzoneWebMusicJsPlugin.EVENT_GET_SONGINFO);
                                                str = jSONObject2.optString("strSongName");
                                                try {
                                                    str5 = jSONObject2.optString("strSingerName");
                                                    try {
                                                        j3 = jSONObject2.getInt("iSongId");
                                                        str6 = jSONObject2.optString("strUrl");
                                                        str7 = str;
                                                    } catch (Exception unused) {
                                                        str6 = "";
                                                        i18 = 0;
                                                        String str9 = str4;
                                                        String str10 = str5;
                                                        String str11 = str2;
                                                        eVar = musicPlayerActivity.f251903a0;
                                                        if (eVar != null) {
                                                        }
                                                        currentSong = null;
                                                        if (i18 != 0) {
                                                        }
                                                        g gVar = new g(str, str10, str11, str9, str6, "https://qzonestyle.gtimg.cn/ac/qzone/applogo/16/308/100497308_16.gif");
                                                        Message obtain = Message.obtain(musicPlayerActivity.f251916n0, 51);
                                                        obtain.arg1 = i18;
                                                        obtain.obj = gVar;
                                                        obtain.sendToTarget();
                                                        Message.obtain(musicPlayerActivity.f251916n0, 53).sendToTarget();
                                                        musicPlayerActivity.l3(str, str10, str11, musicPlayerActivity.h3(musicPlayerActivity.f251903a0, currentSong, j3), z17, i18);
                                                        return;
                                                    }
                                                } catch (Exception unused2) {
                                                    str5 = "";
                                                }
                                            }
                                            str = str7;
                                        } catch (Exception unused3) {
                                            str = "";
                                            str5 = str;
                                        }
                                    } catch (Exception unused4) {
                                        str = "";
                                        str5 = str;
                                        z17 = false;
                                        str6 = "";
                                        i18 = 0;
                                        String str92 = str4;
                                        String str102 = str5;
                                        String str112 = str2;
                                        eVar = musicPlayerActivity.f251903a0;
                                        if (eVar != null) {
                                        }
                                        currentSong = null;
                                        if (i18 != 0) {
                                        }
                                        g gVar2 = new g(str, str102, str112, str92, str6, "https://qzonestyle.gtimg.cn/ac/qzone/applogo/16/308/100497308_16.gif");
                                        Message obtain2 = Message.obtain(musicPlayerActivity.f251916n0, 51);
                                        obtain2.arg1 = i18;
                                        obtain2.obj = gVar2;
                                        obtain2.sendToTarget();
                                        Message.obtain(musicPlayerActivity.f251916n0, 53).sendToTarget();
                                        musicPlayerActivity.l3(str, str102, str112, musicPlayerActivity.h3(musicPlayerActivity.f251903a0, currentSong, j3), z17, i18);
                                        return;
                                    }
                                } catch (Exception unused5) {
                                    str = "";
                                    str4 = str;
                                    str5 = str4;
                                    z17 = false;
                                    str6 = "";
                                    i18 = 0;
                                    String str922 = str4;
                                    String str1022 = str5;
                                    String str1122 = str2;
                                    eVar = musicPlayerActivity.f251903a0;
                                    if (eVar != null) {
                                    }
                                    currentSong = null;
                                    if (i18 != 0) {
                                    }
                                    g gVar22 = new g(str, str1022, str1122, str922, str6, "https://qzonestyle.gtimg.cn/ac/qzone/applogo/16/308/100497308_16.gif");
                                    Message obtain22 = Message.obtain(musicPlayerActivity.f251916n0, 51);
                                    obtain22.arg1 = i18;
                                    obtain22.obj = gVar22;
                                    obtain22.sendToTarget();
                                    Message.obtain(musicPlayerActivity.f251916n0, 53).sendToTarget();
                                    musicPlayerActivity.l3(str, str1022, str1122, musicPlayerActivity.h3(musicPlayerActivity.f251903a0, currentSong, j3), z17, i18);
                                    return;
                                }
                            } catch (Exception unused6) {
                                str = "";
                                str3 = str;
                                str4 = str3;
                                str5 = str4;
                                z17 = false;
                                str6 = "";
                                i18 = 0;
                                String str9222 = str4;
                                String str10222 = str5;
                                String str11222 = str2;
                                eVar = musicPlayerActivity.f251903a0;
                                if (eVar != null) {
                                }
                                currentSong = null;
                                if (i18 != 0) {
                                }
                                g gVar222 = new g(str, str10222, str11222, str9222, str6, "https://qzonestyle.gtimg.cn/ac/qzone/applogo/16/308/100497308_16.gif");
                                Message obtain222 = Message.obtain(musicPlayerActivity.f251916n0, 51);
                                obtain222.arg1 = i18;
                                obtain222.obj = gVar222;
                                obtain222.sendToTarget();
                                Message.obtain(musicPlayerActivity.f251916n0, 53).sendToTarget();
                                musicPlayerActivity.l3(str, str10222, str11222, musicPlayerActivity.h3(musicPlayerActivity.f251903a0, currentSong, j3), z17, i18);
                                return;
                            }
                        } catch (Exception unused7) {
                            str = "";
                            str2 = str;
                            str3 = str2;
                        }
                        String str92222 = str4;
                        String str102222 = str5;
                        String str112222 = str2;
                        eVar = musicPlayerActivity.f251903a0;
                        if (eVar != null) {
                            try {
                                currentSong = eVar.getCurrentSong();
                            } catch (RemoteException unused8) {
                            }
                            if (i18 != 0) {
                                ReportController.o(musicPlayerActivity.app, "CliOper", "", "", "0X8006827", "0X8006827", 0, 0, "", "", "", "");
                                if (currentSong != null) {
                                    String f36 = musicPlayerActivity.f3(currentSong);
                                    if (!TextUtils.isEmpty(str3)) {
                                        str3 = str3.replace("&apos;", "'").replace("&quot;", "\"").replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", ContainerUtils.FIELD_DELIMITER);
                                    }
                                    MusicPlayerActivity.f251900s0.put(f36, Long.valueOf(j3));
                                    MusicPlayerActivity.f251901t0.put(f36, str3);
                                }
                                if (currentSong != null) {
                                    MusicPlayerActivity.f251902u0.put(musicPlayerActivity.f3(currentSong), new h(j3, str, str102222, str6, str92222, str112222, z17));
                                }
                            }
                            g gVar2222 = new g(str, str102222, str112222, str92222, str6, "https://qzonestyle.gtimg.cn/ac/qzone/applogo/16/308/100497308_16.gif");
                            Message obtain2222 = Message.obtain(musicPlayerActivity.f251916n0, 51);
                            obtain2222.arg1 = i18;
                            obtain2222.obj = gVar2222;
                            obtain2222.sendToTarget();
                            Message.obtain(musicPlayerActivity.f251916n0, 53).sendToTarget();
                            musicPlayerActivity.l3(str, str102222, str112222, musicPlayerActivity.h3(musicPlayerActivity.f251903a0, currentSong, j3), z17, i18);
                            return;
                        }
                        currentSong = null;
                        if (i18 != 0) {
                        }
                        g gVar22222 = new g(str, str102222, str112222, str92222, str6, "https://qzonestyle.gtimg.cn/ac/qzone/applogo/16/308/100497308_16.gif");
                        Message obtain22222 = Message.obtain(musicPlayerActivity.f251916n0, 51);
                        obtain22222.arg1 = i18;
                        obtain22222.obj = gVar22222;
                        obtain22222.sendToTarget();
                        Message.obtain(musicPlayerActivity.f251916n0, 53).sendToTarget();
                        musicPlayerActivity.l3(str, str102222, str112222, musicPlayerActivity.h3(musicPlayerActivity.f251903a0, currentSong, j3), z17, i18);
                        return;
                    case 82:
                        QLog.d("MusicPlayerActivity", 4, "MusicPlayerActivity add favourite success ", String.valueOf(str8));
                        try {
                            if (new JSONObject(str8).getInt("code") == 0) {
                                Object tag = musicPlayerActivity.f251907e0.getTag();
                                if (tag instanceof Integer) {
                                    i17 = ((Integer) tag).intValue();
                                } else {
                                    i17 = -1;
                                }
                                Message.obtain(musicPlayerActivity.f251916n0, 54, R.string.cel, i17, musicPlayerActivity.f251907e0).sendToTarget();
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.d("MusicPlayerActivity", 1, "add favourite parse json ", e16);
                            return;
                        }
                    case 83:
                        QLog.d("MusicPlayerActivity", 4, "MusicPlayerActivity del favourite success ", String.valueOf(str8));
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final String f251934a;

        /* renamed from: b, reason: collision with root package name */
        public final String f251935b;

        /* renamed from: c, reason: collision with root package name */
        public final String f251936c;

        /* renamed from: d, reason: collision with root package name */
        public final String f251937d;

        /* renamed from: e, reason: collision with root package name */
        public final String f251938e;

        /* renamed from: f, reason: collision with root package name */
        public final String f251939f;

        public g(String str, String str2, String str3, String str4, String str5, String str6) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4, str5, str6);
                return;
            }
            this.f251934a = str;
            this.f251935b = str2;
            this.f251936c = str3;
            this.f251937d = str4;
            this.f251938e = str5;
            this.f251939f = str6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class h {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final long f251940a;

        /* renamed from: b, reason: collision with root package name */
        public final String f251941b;

        /* renamed from: c, reason: collision with root package name */
        public final String f251942c;

        /* renamed from: d, reason: collision with root package name */
        public final String f251943d;

        /* renamed from: e, reason: collision with root package name */
        public final String f251944e;

        /* renamed from: f, reason: collision with root package name */
        public final String f251945f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f251946g;

        public h(long j3, String str, String str2, String str3, String str4, String str5, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), str, str2, str3, str4, str5, Boolean.valueOf(z16));
                return;
            }
            this.f251940a = j3;
            this.f251941b = str;
            this.f251942c = str2;
            this.f251943d = str3;
            this.f251944e = str4;
            this.f251945f = str5;
            this.f251946g = z16;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73249);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f251900s0 = new HashMap<>();
        f251901t0 = new HashMap<>();
        f251902u0 = new HashMap<>();
    }

    public MusicPlayerActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f251903a0 = null;
        this.f251910h0 = null;
        this.f251911i0 = new f(this);
        this.f251912j0 = new AnonymousClass1();
        this.f251913k0 = new a();
        this.f251914l0 = new b();
        this.f251915m0 = new c();
        this.f251916n0 = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f3(SongInfo songInfo) {
        if (songInfo != null) {
            return songInfo.f251871i + "_____" + String.valueOf(songInfo.f251867d);
        }
        return "";
    }

    private static Point g3(Activity activity) {
        Point point = new Point();
        if (activity != null) {
            activity.getWindowManager().getDefaultDisplay().getSize(point);
        }
        return point;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h3(com.tencent.mobileqq.music.e eVar, SongInfo songInfo, long j3) {
        String str;
        Bundle bundle;
        if (songInfo != null) {
            if (j3 == songInfo.f251867d) {
                songInfo.I = 4;
            }
            int i3 = songInfo.I;
            if (i3 != 4) {
                if (i3 == 6) {
                    str = getString(R.string.cer);
                }
            } else {
                str = getString(R.string.cma);
            }
            if (!TextUtils.isEmpty(str) && eVar != null) {
                try {
                    bundle = eVar.getExtras();
                } catch (RemoteException unused) {
                    bundle = null;
                }
                if (bundle != null) {
                    return bundle.getString("KEY_SOURCE_NAME");
                }
                return str;
            }
        }
        str = "";
        return !TextUtils.isEmpty(str) ? str : str;
    }

    private void i3(String str, LyricViewDetail lyricViewDetail) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.mobileqq.lyric.data.b a16 = com.tencent.mobileqq.lyric.util.b.a(str, true);
        this.f251919q0 = a16;
        if (a16 == null) {
            this.f251918p0 = com.tencent.mobileqq.lyric.util.b.a(str, false);
        }
        if (this.f251919q0 == null && this.f251918p0 == null) {
            return;
        }
        this.f251917o0.m();
        lyricViewDetail.a().setHighlightCurrentLine(true);
        lyricViewDetail.a().setHighlightLineNumber(2);
        this.f251917o0.k(lyricViewDetail);
        this.f251917o0.j(this.f251919q0, this.f251918p0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j3(h hVar, String str) {
        g gVar = new g(hVar.f251941b, hVar.f251942c, hVar.f251945f, hVar.f251944e, hVar.f251943d, "https://qzonestyle.gtimg.cn/ac/qzone/applogo/16/308/100497308_16.gif");
        Message obtain = Message.obtain(this.f251916n0, 51);
        obtain.arg1 = 1;
        obtain.obj = gVar;
        obtain.sendToTarget();
        Message.obtain(this.f251916n0, 53).sendToTarget();
        l3(hVar.f251941b, hVar.f251942c, hVar.f251945f, str, hVar.f251946g, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l3(String str, String str2, String str3, String str4, boolean z16, boolean z17) {
        Message obtain = Message.obtain(this.f251916n0, 52);
        Bundle bundle = new Bundle();
        bundle.putString("KEY_SONG_NAME", str);
        bundle.putString("KEY_SINGER_NAME", str2);
        bundle.putString("KEY_IMG_URL", str3);
        bundle.putString("KEY_SOURCE_NAME", str4);
        bundle.putBoolean("KEY_IS_FAVOURITE", z16);
        bundle.putBoolean("KEY_MATCH_SONG", z17);
        obtain.setData(bundle);
        obtain.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n3(int i3, int i16) {
        Drawable drawable = getResources().getDrawable(i3);
        if (drawable != null) {
            drawable.setColorFilter(i16, PorterDuff.Mode.SRC_IN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p3(String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent();
        intent.setClass(this, ForwardRecentActivity.class);
        intent.putExtra("key_flag_from_plugin", true);
        if (str != null && str.length() > 45) {
            str = str.substring(0, 45) + "\u2026";
        }
        if (str2 != null && str2.length() > 60) {
            str2 = str2.substring(0, 60) + "\u2026";
        }
        intent.putExtra("pluginName", "web_share");
        intent.putExtra("title", str);
        intent.putExtra("desc", str2);
        intent.putExtra("detail_url", str3);
        intent.putExtra("forward_type", 1001);
        intent.putExtra("req_share_id", 1101244924L);
        intent.putExtra("pkg_name", "com.tencent.mobileqq");
        intent.putExtra(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, str4);
        intent.putExtra(AppConstants.Key.SHARE_BRIEF, BaseApplication.getContext().getString(R.string.f171308dy0, str));
        intent.putExtra(AppConstants.Key.SHARE_REQ_AUDIO_URL, str5);
        intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 2);
        intent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
        if (this.app != null) {
            intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_NAME, getString(R.string.f170384pb));
            QQAppInterface qQAppInterface = this.app;
            Share.o(qQAppInterface, this, qQAppInterface.getAccount(), 1101244924L, 3000L, new d(intent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r3(String str, String str2, String str3, String str4, String str5) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("desc", str2);
        bundle.putString("detail_url", str3);
        bundle.putString("from", "qq");
        bundle.putString(AppConstants.Key.SHARE_REQ_AUDIO_URL, str5);
        bundle.putInt(AppConstants.Key.SHARE_REQ_TYPE, 2);
        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add(str4);
        bundle.putStringArrayList("image_url", arrayList);
        bundle.putLong("req_share_id", 0L);
        bundle.putString("strurt_msgid", "0");
        bundle.putString("struct_url", this.app.getCurrentUin());
        bundle.putBoolean(QZoneShareManager.QZONE_SHARE_FROM_WEB, true);
        QZoneShareManager.jumpToQzoneShare(this.app, this, bundle, (DialogInterface.OnDismissListener) null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0056 A[Catch: Exception -> 0x00f9, TryCatch #0 {Exception -> 0x00f9, blocks: (B:7:0x001a, B:9:0x0025, B:11:0x0031, B:13:0x0043, B:14:0x004c, B:16:0x0056, B:17:0x005f, B:19:0x0065, B:21:0x0072, B:25:0x0090, B:28:0x00a4, B:30:0x00ab, B:32:0x00b3, B:33:0x00b8, B:37:0x00e8, B:39:0x00f3, B:42:0x0082), top: B:6:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0065 A[Catch: Exception -> 0x00f9, TryCatch #0 {Exception -> 0x00f9, blocks: (B:7:0x001a, B:9:0x0025, B:11:0x0031, B:13:0x0043, B:14:0x004c, B:16:0x0056, B:17:0x005f, B:19:0x0065, B:21:0x0072, B:25:0x0090, B:28:0x00a4, B:30:0x00ab, B:32:0x00b3, B:33:0x00b8, B:37:0x00e8, B:39:0x00f3, B:42:0x0082), top: B:6:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0072 A[Catch: Exception -> 0x00f9, TryCatch #0 {Exception -> 0x00f9, blocks: (B:7:0x001a, B:9:0x0025, B:11:0x0031, B:13:0x0043, B:14:0x004c, B:16:0x0056, B:17:0x005f, B:19:0x0065, B:21:0x0072, B:25:0x0090, B:28:0x00a4, B:30:0x00ab, B:32:0x00b3, B:33:0x00b8, B:37:0x00e8, B:39:0x00f3, B:42:0x0082), top: B:6:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void s3() {
        long j3;
        Object tag;
        long j16;
        com.tencent.mobileqq.music.e eVar = this.f251903a0;
        if (eVar == null) {
            QLog.e("MusicPlayerActivity", 1, "updateLyricPosition() exception", "mService is null!");
            return;
        }
        try {
            SongInfo currentSong = eVar.getCurrentSong();
            String str = "";
            long j17 = 0;
            if (currentSong != null) {
                String f36 = f3(currentSong);
                HashMap<String, Long> hashMap = f251900s0;
                if (hashMap.containsKey(f36)) {
                    j3 = hashMap.get(f36).longValue();
                    HashMap<String, String> hashMap2 = f251901t0;
                    if (hashMap2.containsKey(f36)) {
                        str = hashMap2.get(f36);
                    }
                    tag = this.f251920r0.getTag();
                    if (!(tag instanceof Long)) {
                        j16 = ((Long) tag).longValue();
                    } else {
                        j16 = -1;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        this.f251920r0.setVisibility(4);
                        this.f251917o0.m();
                        return;
                    }
                    if (this.f251920r0.a().d() == null || j16 != j3) {
                        i3(str, this.f251920r0);
                        this.f251920r0.setTag(Long.valueOf(j3));
                    }
                    int playState = eVar.getPlayState();
                    this.f251920r0.setVisibility(0);
                    long w3 = eVar.w3();
                    if (w3 >= 0) {
                        j17 = w3;
                    }
                    int i3 = (int) j17;
                    if (eVar.isPlaying()) {
                        boolean c16 = this.f251917o0.c();
                        if (!c16) {
                            this.f251917o0.l();
                        }
                        QLog.i("MusicPlayerActivity", 1, "LyricTest updateLyricPosition() try to seek! playPosition:" + j17 + " seekPosition:" + i3 + " isPlaying:" + c16);
                        this.f251917o0.i(i3);
                        return;
                    }
                    if (3 == playState) {
                        this.f251917o0.i(i3);
                        this.f251917o0.h();
                        return;
                    } else {
                        this.f251917o0.m();
                        return;
                    }
                }
            }
            j3 = 0;
            tag = this.f251920r0.getTag();
            if (!(tag instanceof Long)) {
            }
            if (!TextUtils.isEmpty(str)) {
            }
        } catch (Exception e16) {
            QLog.e("MusicPlayerActivity", 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mNeedStatusTrans = false;
        boolean doOnCreate = super.doOnCreate(bundle);
        try {
            setContentView(R.layout.f168317sm);
            bindService(new Intent(this, (Class<?>) QQPlayerService.class), this.f251913k0, 33);
            View findViewById = findViewById(R.id.f3w);
            View findViewById2 = findViewById(R.id.f3l);
            int i3 = g3(this).x;
            findViewById.getLayoutParams().height = i3;
            findViewById2.getLayoutParams().height = i3;
            this.f251904b0 = (TextView) findViewById(R.id.f3v);
            this.f251905c0 = (TextView) findViewById(R.id.f3p);
            this.f251907e0 = (ImageView) findViewById(R.id.f3r);
            this.f251906d0 = (ImageView) findViewById(R.id.f3t);
            this.f251908f0 = (ImageView) findViewById(R.id.f3o);
            this.f251906d0.setOnClickListener(this.f251912j0);
            this.f251910h0 = (MusicPlayerHandler) this.app.getBusinessHandler(BusinessHandlerFactory.MUSIC_PLAYER_HANDLER);
            LyricViewDetail lyricViewDetail = (LyricViewDetail) findViewById(R.id.f3s);
            this.f251920r0 = lyricViewDetail;
            this.f251917o0 = new LyricViewController(lyricViewDetail);
            findViewById(R.id.f3m).setOnClickListener(this.f251912j0);
            this.f251907e0.setOnClickListener(this.f251912j0);
            ImageView imageView = (ImageView) findViewById(R.id.f3u);
            this.f251909g0 = imageView;
            imageView.setOnClickListener(this.f251912j0);
            this.f251908f0.setOnClickListener(this.f251912j0);
            addObserver(this.f251911i0);
            ReportController.o(this.app, "CliOper", "", "", "0X8006826", "0X8006826", 0, 0, "", "", "", "");
            return doOnCreate;
        } catch (OutOfMemoryError unused) {
            finish();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.mobileqq.music.e eVar = this.f251903a0;
        if (eVar != null) {
            try {
                eVar.X3(this.f251914l0);
            } catch (RemoteException unused) {
            }
        }
        unbindService(this.f251913k0);
        removeObserver(this.f251911i0);
        super.doOnDestroy();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        try {
            LyricViewController lyricViewController = this.f251917o0;
            if (lyricViewController != null) {
                lyricViewController.m();
            }
        } catch (Exception e16) {
            QLog.e("MusicPlayerActivity", 1, e16, new Object[0]);
        }
        super.onDestroy();
    }
}
