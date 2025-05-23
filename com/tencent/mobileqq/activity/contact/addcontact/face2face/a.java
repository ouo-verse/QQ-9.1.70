package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import android.animation.Animator;
import android.graphics.Bitmap;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends RecyclerView.Adapter {
    static IPatchRedirector $redirector_;
    private Set<String> C;
    private DecodeTaskCompletionListener D;

    /* renamed from: d, reason: collision with root package name */
    private List<d> f181063d;

    /* renamed from: e, reason: collision with root package name */
    private BaseActivity f181064e;

    /* renamed from: f, reason: collision with root package name */
    private QQAppInterface f181065f;

    /* renamed from: h, reason: collision with root package name */
    private IFaceDecoder f181066h;

    /* renamed from: i, reason: collision with root package name */
    private RecyclerView f181067i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f181068m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.contact.addcontact.face2face.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C7150a implements DecodeTaskCompletionListener {
        static IPatchRedirector $redirector_;

        C7150a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
        public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
                return;
            }
            if (bitmap != null && !TextUtils.isEmpty(str)) {
                int childCount = a.this.f181067i.getChildCount();
                for (int i17 = 0; i17 < childCount; i17++) {
                    RecyclerView.ViewHolder childViewHolder = a.this.f181067i.getChildViewHolder(a.this.f181067i.getChildAt(i17));
                    if (childViewHolder instanceof b) {
                        b bVar = (b) childViewHolder;
                        if (bVar.f181070d.equals(str)) {
                            bVar.f181071e.setImageBitmap(bitmap);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b extends RecyclerView.ViewHolder implements View.OnClickListener, Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        String f181070d;

        /* renamed from: e, reason: collision with root package name */
        ImageView f181071e;

        /* renamed from: f, reason: collision with root package name */
        TextView f181072f;

        /* renamed from: h, reason: collision with root package name */
        LottieAnimationView f181073h;

        public b(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) view);
                return;
            }
            this.f181073h = (LottieAnimationView) view.findViewById(R.id.ifi);
            this.f181071e = (ImageView) view.findViewById(R.id.icon);
            this.f181072f = (TextView) view.findViewById(R.id.f5e);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                return;
            }
            this.f181073h.setVisibility(4);
            this.f181071e.setAlpha(1.0f);
            a.this.C.add(this.f181070d);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (view.getId() == R.id.icon) {
                a.this.w(this.f181070d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                onAnimationStart(animator);
            } else {
                iPatchRedirector.redirect((short) 7, this, animator, Boolean.valueOf(z16));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                onAnimationEnd(animator);
            } else {
                iPatchRedirector.redirect((short) 8, this, animator, Boolean.valueOf(z16));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        String f181075d;

        /* renamed from: e, reason: collision with root package name */
        ImageView f181076e;

        /* renamed from: f, reason: collision with root package name */
        TextView f181077f;

        /* renamed from: h, reason: collision with root package name */
        LottieAnimationView f181078h;

        public c(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) view);
                return;
            }
            this.f181078h = (LottieAnimationView) view.findViewById(R.id.ifi);
            this.f181076e = (ImageView) view.findViewById(R.id.icon);
            this.f181077f = (TextView) view.findViewById(R.id.f5e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaseActivity baseActivity, QQAppInterface qQAppInterface, RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, baseActivity, qQAppInterface, recyclerView);
            return;
        }
        this.D = new C7150a();
        this.f181064e = baseActivity;
        this.f181065f = qQAppInterface;
        this.f181067i = recyclerView;
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) qQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(qQAppInterface);
        this.f181066h = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this.D);
        this.f181068m = SimpleUIUtil.getSimpleUISwitch();
        this.C = new HashSet();
        this.f181063d = new ArrayList();
    }

    private String v(String str) {
        if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "Face2FaceAddContactAdapter")) {
            return ac.F(this.f181065f, str);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str) {
        AllInOne allInOne = new AllInOne(str, 113);
        allInOne.profileEntryType = 126;
        allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 11);
        allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 111);
        ProfileUtils.openProfileCard(this.f181064e, allInOne);
    }

    private void x(boolean z16, RecyclerView.ViewHolder viewHolder, d dVar) {
        String str;
        if (z16) {
            c cVar = (c) viewHolder;
            ViewCompat.setImportantForAccessibility(cVar.itemView, 2);
            cVar.f181076e.setImageResource(R.drawable.bzr);
            cVar.f181077f.setText((CharSequence) null);
            cVar.f181075d = "";
            cVar.f181078h.setVisibility(0);
            cVar.f181078h.setAnimation("normal_loading_new.json");
            cVar.f181078h.loop(true);
            cVar.f181078h.playAnimation();
            return;
        }
        b bVar = (b) viewHolder;
        if (dVar != null && !TextUtils.isEmpty(dVar.f181080a)) {
            bVar.f181071e.setImageBitmap(t(dVar.f181080a));
            bVar.f181071e.setOnTouchListener(ba.f77070d);
            bVar.f181071e.setOnClickListener(bVar);
            if (TextUtils.isEmpty(dVar.f181081b)) {
                str = v(dVar.f181080a);
            } else {
                str = dVar.f181081b;
            }
            bVar.f181072f.setText(v(str));
            bVar.f181070d = dVar.f181080a;
            bVar.itemView.setContentDescription(bVar.f181072f.getText().toString());
            if (dVar.a()) {
                if (!this.C.contains(dVar.f181080a)) {
                    bVar.f181071e.setAlpha(0.5f);
                    bVar.f181073h.setVisibility(0);
                    bVar.f181073h.setAnimation("face2face/normal_avatar.json");
                    bVar.f181073h.playAnimation();
                    bVar.f181073h.addAnimatorListener(bVar);
                    return;
                }
                return;
            }
            if (bVar.f181071e.getAlpha() < 1.0d || bVar.f181073h.getVisibility() != 4) {
                bVar.f181073h.setVisibility(4);
                bVar.f181071e.setAlpha(1.0f);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f181063d.size() + 1;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, i3)).intValue();
        }
        if (i3 >= this.f181063d.size()) {
            return 1;
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewHolder, i3);
        } else if (viewHolder instanceof c) {
            x(true, viewHolder, null);
        } else {
            x(false, viewHolder, this.f181063d.get(i3));
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
        }
        View inflate = LayoutInflater.from(this.f181064e).inflate(R.layout.f168812b03, viewGroup, false);
        if (i3 == 1) {
            return new c(inflate);
        }
        return new b(inflate);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onDestroy() {
        this.f181065f = null;
        this.f181064e = null;
        this.f181067i = null;
        s();
        IFaceDecoder iFaceDecoder = this.f181066h;
        if (iFaceDecoder != null) {
            iFaceDecoder.setDecodeTaskCompletionListener(null);
            this.D = null;
            this.f181066h.destory();
        }
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Set<String> set = this.C;
        if (set != null) {
            set.clear();
        }
        List<d> list = this.f181063d;
        if (list != null) {
            list.clear();
        }
    }

    protected Bitmap t(String str) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bitmap) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        IFaceDecoder iFaceDecoder = this.f181066h;
        if (iFaceDecoder != null) {
            bitmap = iFaceDecoder.getBitmapFromCache(1, str);
            if (bitmap == null) {
                this.f181066h.requestDecodeFace(str, 1, false, (byte) 1);
            }
        } else {
            bitmap = null;
        }
        if (bitmap == null) {
            return BaseImageUtil.getDefaultFaceBitmap();
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<d> u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f181063d;
    }
}
