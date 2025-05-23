package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ActivateFriendGrid extends FrameLayout implements DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_;
    private static Bitmap M;
    private static int N;
    private static int P;
    private int C;
    private int D;
    private d E;
    private IFaceDecoder F;
    private Hashtable<String, Bitmap> G;
    private QQAppInterface H;
    ActivateFriendsManager I;
    private View.OnClickListener J;
    ar K;
    com.tencent.mobileqq.app.activateFriends.b L;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<ActivateFriendItem> f177819d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<ActivateFriendGridItem> f177820e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f177821f;

    /* renamed from: h, reason: collision with root package name */
    private int f177822h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f177823i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f177824m;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActivateFriendGrid.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ActivateFriendGridItem activateFriendGridItem = (ActivateFriendGridItem) view;
                if (activateFriendGridItem.f177833m) {
                    ActivateFriendGrid activateFriendGrid = ActivateFriendGrid.this;
                    activateFriendGrid.f177822h--;
                } else {
                    ActivateFriendGrid.this.f177822h++;
                }
                activateFriendGridItem.setChecked(!activateFriendGridItem.f177833m);
                if (ActivateFriendGrid.this.E != null) {
                    ActivateFriendGrid.this.E.M(ActivateFriendGrid.this.f177822h);
                }
                ActivateFriendGrid.f(ActivateFriendGrid.this);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b extends ar {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActivateFriendGrid.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendInfo(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
                return;
            }
            for (int i3 = 0; i3 < ActivateFriendGrid.this.f177819d.size(); i3++) {
                String valueOf = String.valueOf(((ActivateFriendItem) ActivateFriendGrid.this.f177819d.get(i3)).uin);
                if (str.equals(valueOf)) {
                    ((ActivateFriendGridItem) ActivateFriendGrid.this.f177820e.get(i3)).setNickName(com.tencent.mobileqq.utils.ac.g(ActivateFriendGrid.this.H, valueOf, false));
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateFriendList(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            for (int i3 = 0; i3 < ActivateFriendGrid.this.f177819d.size(); i3++) {
                ((ActivateFriendGridItem) ActivateFriendGrid.this.f177820e.get(i3)).setNickName(com.tencent.mobileqq.utils.ac.y(ActivateFriendGrid.this.H, String.valueOf(((ActivateFriendItem) ActivateFriendGrid.this.f177819d.get(i3)).uin)));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c extends com.tencent.mobileqq.app.activateFriends.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActivateFriendGrid.this);
            }
        }

        @Override // com.tencent.mobileqq.app.activateFriends.b
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (ActivateFriendGrid.this.f177819d != null && ActivateFriendGrid.this.f177820e != null) {
                for (int i3 = 0; i3 < ActivateFriendGrid.this.f177819d.size(); i3++) {
                    ActivateFriendGrid activateFriendGrid = ActivateFriendGrid.this;
                    if (activateFriendGrid.I.x(((ActivateFriendItem) activateFriendGrid.f177819d.get(i3)).uin, 2)) {
                        ((ActivateFriendGridItem) ActivateFriendGrid.this.f177820e.get(i3)).setChecked(false);
                        ((ActivateFriendGridItem) ActivateFriendGrid.this.f177820e.get(i3)).setBirthday(ActivateFriendGrid.this.getResources().getString(R.string.f169997c8));
                    } else {
                        ActivateFriendGrid activateFriendGrid2 = ActivateFriendGrid.this;
                        if (activateFriendGrid2.I.z(((ActivateFriendItem) activateFriendGrid2.f177819d.get(i3)).uin, 2)) {
                            ((ActivateFriendGridItem) ActivateFriendGrid.this.f177820e.get(i3)).setChecked(false);
                            ((ActivateFriendGridItem) ActivateFriendGrid.this.f177820e.get(i3)).setBirthday(ActivateFriendGrid.this.getResources().getString(R.string.f169999ca));
                        }
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface d {
        void M(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface e {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67645);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        M = null;
        N = 15;
        P = 14;
    }

    public ActivateFriendGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f177819d = new ArrayList<>();
        this.f177820e = new ArrayList<>();
        this.f177821f = true;
        this.f177822h = 0;
        this.f177823i = false;
        this.f177824m = true;
        this.E = null;
        this.G = new Hashtable<>();
        this.J = new a();
        this.K = new b();
        this.L = new c();
    }

    static /* bridge */ /* synthetic */ e f(ActivateFriendGrid activateFriendGrid) {
        activateFriendGrid.getClass();
        return null;
    }

    private int k(int i3, int i16) {
        if (i16 < 3) {
            return i16;
        }
        if (i3 < 3) {
            return 3;
        }
        return i16 - 3;
    }

    private Bitmap l(String str) {
        Bitmap bitmapFromCache = this.F.getBitmapFromCache(1, str);
        if (bitmapFromCache != null) {
            return bitmapFromCache;
        }
        if (!this.F.isPausing()) {
            this.F.requestDecodeFace(str, 1, true, (byte) 0);
        }
        return M;
    }

    private int m(int i3) {
        int i16 = 0;
        if (this.f177820e.size() > 0) {
            i16 = this.f177820e.get(0).getMeasuredHeight();
        }
        return (i16 * 2) + (1 * com.tencent.mobileqq.util.x.c(getContext(), N));
    }

    public ActivateFriendGridItem h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ActivateFriendGridItem) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        ActivateFriendGridItem activateFriendGridItem = new ActivateFriendGridItem(getContext(), this.f177823i, this.f177824m);
        addView(activateFriendGridItem, new FrameLayout.LayoutParams(-2, -2));
        return activateFriendGridItem;
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        IFaceDecoder iFaceDecoder = this.F;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
            this.F = null;
        }
        QQAppInterface qQAppInterface = this.H;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.K);
            this.H.unRegistObserver(this.L);
        }
    }

    public long[] j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (long[]) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        long[] jArr = new long[this.f177822h];
        int i3 = 0;
        for (int i16 = 0; i16 < this.f177820e.size(); i16++) {
            if (this.f177820e.get(i16).f177833m) {
                jArr[i3] = this.f177819d.get(i16).uin;
                i3++;
            }
        }
        return jArr;
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            return;
        }
        if (!this.F.isPausing()) {
            if (bitmap != null) {
                this.G.put(str, bitmap);
            }
            if (i3 <= 0) {
                int size = this.f177820e.size();
                for (int i17 = 0; i17 < size; i17++) {
                    Bitmap bitmap2 = this.G.get(String.valueOf(this.f177819d.get(i17).uin));
                    if (bitmap2 != null) {
                        this.f177820e.get(i17).setHead(bitmap2);
                    }
                }
                this.G.clear();
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        char c16;
        int i19;
        int i26;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i27 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        int size = this.f177820e.size();
        if (size > 3) {
            c16 = 2;
        } else {
            c16 = 1;
        }
        int i28 = 0;
        int i29 = 0;
        while (i28 < size) {
            int k3 = k(i28, size);
            ActivateFriendGridItem activateFriendGridItem = this.f177820e.get(i28);
            int measuredHeight = activateFriendGridItem.getMeasuredHeight();
            int measuredWidth = activateFriendGridItem.getMeasuredWidth();
            int i36 = i28 / 3;
            int i37 = i28 % 3;
            if (i37 == 0) {
                if (this.f177820e.size() > 0) {
                    i26 = this.f177820e.get(i27).getMeasuredWidth();
                } else {
                    i26 = i27;
                }
                int i38 = i26 * k3;
                int i39 = k3 - 1;
                int c17 = (com.tencent.mobileqq.util.x.c(getContext(), P) * i39) + i38;
                int i46 = this.C;
                if (c17 > i46) {
                    i29 = (i46 - i38) / (k3 + 2);
                    P = i29;
                } else {
                    i29 = ((i46 - i38) - (com.tencent.mobileqq.util.x.c(getContext(), P) * i39)) / 2;
                }
            }
            if (c16 > 1) {
                i19 = (i36 * measuredHeight) + (i36 * com.tencent.mobileqq.util.x.c(getContext(), N));
            } else {
                i19 = (this.D / 2) - (measuredHeight / 2);
            }
            int c18 = (i37 * measuredWidth) + i29 + (i37 * com.tencent.mobileqq.util.x.c(getContext(), P));
            activateFriendGridItem.layout(c18, i19, measuredWidth + c18, measuredHeight + i19);
            i28++;
            i27 = 0;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        this.C = getMeasuredWidth();
        this.D = m(i16);
        setMeasuredDimension(getMeasuredWidth(), this.D);
    }

    public void setCheckAbilityEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.f177821f = z16;
        }
    }

    public void setData(QQAppInterface qQAppInterface, ArrayList<ActivateFriendItem> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) qQAppInterface, (Object) arrayList);
            return;
        }
        this.H = qQAppInterface;
        if (M == null) {
            M = BaseImageUtil.getDefaultFaceBitmap();
        }
        this.f177819d.clear();
        Iterator<ActivateFriendGridItem> it = this.f177820e.iterator();
        while (it.hasNext()) {
            removeView(it.next());
        }
        this.f177820e.clear();
        this.f177819d.addAll(arrayList);
        if (this.F == null) {
            IFaceDecoder iQQAvatarService = ((IQQAvatarService) this.H.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.H);
            this.F = iQQAvatarService;
            iQQAvatarService.setDecodeTaskCompletionListener(this);
        }
        this.I = (ActivateFriendsManager) this.H.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
        this.H.addObserver(this.K);
        this.H.registObserver(this.L);
        this.f177822h = 0;
        int size = this.f177819d.size();
        for (int i3 = 0; i3 < size; i3++) {
            ActivateFriendGridItem h16 = h();
            h16.setIndex(i3);
            h16.setBirthday(this.f177819d.get(i3).birthdayDesc);
            h16.setCheckViewGone();
            String valueOf = String.valueOf(this.f177819d.get(i3).uin);
            if (!TextUtils.isEmpty(this.f177819d.get(i3).nickName)) {
                h16.setNickName(this.f177819d.get(i3).nickName);
            } else {
                h16.setNickName(com.tencent.mobileqq.utils.ac.g(this.H, valueOf, true));
            }
            h16.setHead(l(valueOf));
            if (this.f177821f) {
                h16.setOnClickListener(this.J);
            }
            if (this.f177821f) {
                if (!getResources().getString(R.string.f169997c8).equals(this.f177819d.get(i3).birthdayDesc) && !this.I.x(this.f177819d.get(i3).uin, this.f177819d.get(i3).type)) {
                    if (!this.I.y(this.f177819d.get(i3).uin, this.f177819d.get(i3).type) && !this.I.z(this.f177819d.get(i3).uin, this.f177819d.get(i3).type)) {
                        this.f177822h++;
                        h16.setChecked(true);
                    } else {
                        h16.setChecked(false);
                        h16.setBirthday(getResources().getString(R.string.f169999ca));
                    }
                } else {
                    h16.setChecked(false);
                    h16.setBirthday(getResources().getString(R.string.f169997c8));
                }
            }
            this.f177820e.add(h16);
        }
        d dVar = this.E;
        if (dVar != null) {
            dVar.M(this.f177822h);
        }
    }

    public void setGridCallBack(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
        } else {
            this.E = dVar;
        }
    }

    public void setGridItemClickCallBack(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
        }
    }

    public void setSkinable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.f177823i = z16;
        }
    }

    public void setTextScrolling(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.f177824m = z16;
        }
    }
}
