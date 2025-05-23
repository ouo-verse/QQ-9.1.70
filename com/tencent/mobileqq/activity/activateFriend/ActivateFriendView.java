package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;
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
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ActivateFriendView extends LinearLayout implements DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_;
    private static Bitmap K;
    private static final int L;
    private static final int M;
    private static final int N;
    private static final int P;
    private ActivateFriendGrid.d C;
    private IFaceDecoder D;
    private Hashtable<String, Bitmap> E;
    private QQAppInterface F;
    ActivateFriendsManager G;
    private View.OnClickListener H;
    ar I;
    com.tencent.mobileqq.app.activateFriends.b J;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<ActivateFriendItem> f177834d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<ActivateFriendViewItem> f177835e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f177836f;

    /* renamed from: h, reason: collision with root package name */
    private int f177837h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f177838i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f177839m;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActivateFriendView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ActivateFriendViewItem activateFriendViewItem = (ActivateFriendViewItem) view;
                if (activateFriendViewItem.f177848m) {
                    ActivateFriendView activateFriendView = ActivateFriendView.this;
                    activateFriendView.f177837h--;
                } else {
                    ActivateFriendView.this.f177837h++;
                }
                activateFriendViewItem.setChecked(!activateFriendViewItem.f177848m);
                if (ActivateFriendView.this.C != null) {
                    ActivateFriendView.this.C.M(ActivateFriendView.this.f177837h);
                }
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActivateFriendView.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendInfo(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
                return;
            }
            for (int i3 = 0; i3 < ActivateFriendView.this.f177834d.size(); i3++) {
                String valueOf = String.valueOf(((ActivateFriendItem) ActivateFriendView.this.f177834d.get(i3)).uin);
                if (str.equals(valueOf)) {
                    ((ActivateFriendViewItem) ActivateFriendView.this.f177835e.get(i3)).setNickName(com.tencent.mobileqq.utils.ac.g(ActivateFriendView.this.F, valueOf, false));
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
            for (int i3 = 0; i3 < ActivateFriendView.this.f177834d.size(); i3++) {
                ((ActivateFriendViewItem) ActivateFriendView.this.f177835e.get(i3)).setNickName(com.tencent.mobileqq.utils.ac.y(ActivateFriendView.this.F, String.valueOf(((ActivateFriendItem) ActivateFriendView.this.f177834d.get(i3)).uin)));
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActivateFriendView.this);
            }
        }

        @Override // com.tencent.mobileqq.app.activateFriends.b
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (ActivateFriendView.this.f177834d != null && ActivateFriendView.this.f177835e != null) {
                ActivateFriendView.this.f177837h = 0;
                for (int i3 = 0; i3 < ActivateFriendView.this.f177834d.size(); i3++) {
                    ActivateFriendView activateFriendView = ActivateFriendView.this;
                    if (activateFriendView.G.x(((ActivateFriendItem) activateFriendView.f177834d.get(i3)).uin, 2)) {
                        ((ActivateFriendViewItem) ActivateFriendView.this.f177835e.get(i3)).setChecked(false);
                        ((ActivateFriendViewItem) ActivateFriendView.this.f177835e.get(i3)).setBirthday(ActivateFriendView.this.getResources().getString(R.string.f169997c8));
                    } else {
                        ActivateFriendView activateFriendView2 = ActivateFriendView.this;
                        if (activateFriendView2.G.z(((ActivateFriendItem) activateFriendView2.f177834d.get(i3)).uin, 2)) {
                            ((ActivateFriendViewItem) ActivateFriendView.this.f177835e.get(i3)).setChecked(false);
                            ((ActivateFriendViewItem) ActivateFriendView.this.f177835e.get(i3)).setBirthday(ActivateFriendView.this.getResources().getString(R.string.f169999ca));
                        } else {
                            ActivateFriendView.this.f177837h++;
                            ((ActivateFriendViewItem) ActivateFriendView.this.f177835e.get(i3)).setChecked(true);
                        }
                    }
                }
                if (ActivateFriendView.this.C != null) {
                    ActivateFriendView.this.C.M(ActivateFriendView.this.f177837h);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67651);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        K = null;
        L = ViewUtils.dpToPx(85.0f);
        M = ViewUtils.dpToPx(70.0f);
        N = ViewUtils.dpToPx(70.0f);
        P = ViewUtils.dpToPx(52.0f);
    }

    public ActivateFriendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f177834d = new ArrayList<>();
        this.f177835e = new ArrayList<>();
        this.f177836f = true;
        this.f177837h = 0;
        this.f177838i = false;
        this.f177839m = true;
        this.C = null;
        this.E = new Hashtable<>();
        this.H = new a();
        this.I = new b();
        this.J = new c();
    }

    private Bitmap h(String str) {
        Bitmap bitmapFromCache = this.D.getBitmapFromCache(1, str);
        if (bitmapFromCache != null) {
            return bitmapFromCache;
        }
        if (!this.D.isPausing()) {
            this.D.requestDecodeFace(str, 1, true, (byte) 0);
        }
        return K;
    }

    public ActivateFriendViewItem g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ActivateFriendViewItem) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        ActivateFriendViewItem activateFriendViewItem = new ActivateFriendViewItem(getContext(), this.f177838i, this.f177839m);
        addView(activateFriendViewItem, new LinearLayout.LayoutParams(i3, -2));
        return activateFriendViewItem;
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            return;
        }
        if (!this.D.isPausing()) {
            if (bitmap != null) {
                this.E.put(str, bitmap);
            }
            if (i3 <= 0) {
                int size = this.f177835e.size();
                for (int i17 = 0; i17 < size; i17++) {
                    Bitmap bitmap2 = this.E.get(String.valueOf(this.f177834d.get(i17).uin));
                    if (bitmap2 != null) {
                        this.f177835e.get(i17).setHead(bitmap2);
                    }
                }
                this.E.clear();
            }
        }
    }

    public void setCheckAbilityEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.f177836f = z16;
        }
    }

    public void setData(QQAppInterface qQAppInterface, ArrayList<ActivateFriendItem> arrayList) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) qQAppInterface, (Object) arrayList);
            return;
        }
        this.F = qQAppInterface;
        if (K == null) {
            K = BaseImageUtil.getDefaultFaceBitmap();
        }
        this.f177834d.clear();
        Iterator<ActivateFriendViewItem> it = this.f177835e.iterator();
        while (it.hasNext()) {
            removeView(it.next());
        }
        this.f177835e.clear();
        this.f177834d.addAll(arrayList);
        if (this.D == null) {
            IFaceDecoder iQQAvatarService = ((IQQAvatarService) this.F.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.F);
            this.D = iQQAvatarService;
            iQQAvatarService.setDecodeTaskCompletionListener(this);
        }
        this.G = (ActivateFriendsManager) this.F.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
        this.F.addObserver(this.I);
        this.F.registObserver(this.J);
        this.f177837h = 0;
        int size = this.f177834d.size();
        if (size != 2) {
            if (size != 3) {
                if (size != 4) {
                    if (size != 5) {
                        i3 = -2;
                    } else {
                        i3 = P;
                    }
                } else {
                    i3 = N;
                }
            } else {
                i3 = M;
            }
        } else {
            i3 = L;
        }
        for (int i16 = 0; i16 < size; i16++) {
            ActivateFriendViewItem g16 = g(i3);
            g16.setBirthday(this.f177834d.get(i16).birthdayDesc);
            String valueOf = String.valueOf(this.f177834d.get(i16).uin);
            if (!TextUtils.isEmpty(this.f177834d.get(i16).nickName)) {
                g16.setNickName(this.f177834d.get(i16).nickName);
            } else {
                g16.setNickName(com.tencent.mobileqq.utils.ac.g(this.F, valueOf, true));
            }
            g16.setHead(h(valueOf));
            if (this.f177836f) {
                g16.setOnClickListener(this.H);
            }
            if (this.f177836f) {
                if (!getResources().getString(R.string.f169997c8).equals(this.f177834d.get(i16).birthdayDesc) && !this.G.x(this.f177834d.get(i16).uin, this.f177834d.get(i16).type)) {
                    if (!this.G.y(this.f177834d.get(i16).uin, this.f177834d.get(i16).type) && !this.G.z(this.f177834d.get(i16).uin, this.f177834d.get(i16).type)) {
                        this.f177837h++;
                        g16.setChecked(true);
                    } else {
                        g16.setChecked(false);
                        g16.setBirthday(getResources().getString(R.string.f169999ca));
                    }
                } else {
                    g16.setChecked(false);
                    g16.setBirthday(getResources().getString(R.string.f169997c8));
                }
            }
            this.f177835e.add(g16);
        }
        ActivateFriendGrid.d dVar = this.C;
        if (dVar != null) {
            dVar.M(this.f177837h);
        }
    }

    public void setGridCallBack(ActivateFriendGrid.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
        } else {
            this.C = dVar;
        }
    }

    public void setSkinable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.f177838i = z16;
        }
    }

    public void setTextScrolling(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.f177839m = z16;
        }
    }
}
