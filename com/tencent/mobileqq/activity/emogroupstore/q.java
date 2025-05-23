package com.tencent.mobileqq.activity.emogroupstore;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.emosm.api.IEmoticonFromGroupDBManagerService;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.ao;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class q extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static IPatchRedirector $redirector_;
    private Context C;
    private EmoticonGroupStoreFragment D;
    private Map<String, List<EmoticonFromGroupEntity>> E;
    private Map<String, String> F;
    private int G;
    private LayoutInflater H;
    private Map<Integer, Integer> I;
    private Map<Integer, String> J;
    private Map<Integer, List<EmoticonFromGroupEntity>> K;
    public boolean L;
    private boolean M;
    private int N;
    private int P;
    private View Q;
    private Button R;
    private ImageView S;
    private TextView T;
    private ViewPager U;
    private o V;
    private Button W;
    private IEmoticonFromGroupDBManagerService X;
    private com.tencent.mobileqq.emosm.favroaming.l Y;
    private final LifecycleCoroutineScope Z;

    /* renamed from: a0, reason: collision with root package name */
    private SpannableString f182164a0;

    /* renamed from: b0, reason: collision with root package name */
    private com.tencent.mobileqq.activity.emogroupstore.report.a f182165b0;

    /* renamed from: c0, reason: collision with root package name */
    private g f182166c0;

    /* renamed from: m, reason: collision with root package name */
    private QQAppInterface f182167m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements ViewPager.OnPageChangeListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) q.this);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            EmoticonFromGroupEntity f16 = q.this.V.f(i3);
            if (f16 != null) {
                q.this.w0(f16);
                q.this.x0(f16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) q.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            if (i3 == 1) {
                VasH5PayUtil.openClubPay(q.this.C, "mvip.n.a.bqsc_ql", 3, "1450000516", "CJCLUBT", q.this.f182167m.getApp().getString(R.string.f173184hu3), "");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c implements g {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) q.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.emogroupstore.q.g
        public void a(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                q.this.p0(i3, i16);
            } else {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class d extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        TextView E;

        d(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            } else {
                this.E = (TextView) view.findViewById(R.id.kec);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class e extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        TextView E;

        e(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                return;
            }
            this.E = (TextView) view.findViewById(R.id.kdv);
            if (FontSettingManager.getFontScale() > 1.0f) {
                FontSettingManager.resetViewSize2Normal(view.getContext(), this.E);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class f extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        TextView E;

        f(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            } else {
                this.E = (TextView) view.findViewById(R.id.kdm);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface g {
        void a(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class h extends RecyclerView.ViewHolder implements View.OnClickListener {
        static IPatchRedirector $redirector_;
        public ImageView E;
        public NumberCheckBox F;
        public ImageView G;
        public ImageView H;
        public NumberCheckBox I;
        public ImageView J;
        public ImageView K;
        public NumberCheckBox L;
        public ImageView M;
        public ImageView[] N;
        public NumberCheckBox[] P;
        public ImageView[] Q;
        private g R;

        public h(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                return;
            }
            View findViewById = view.findViewById(R.id.xsf);
            this.E = (ImageView) view.findViewById(R.id.f165777dh0);
            this.F = (NumberCheckBox) view.findViewById(R.id.axb);
            this.G = (ImageView) view.findViewById(R.id.dht);
            View findViewById2 = view.findViewById(R.id.xsg);
            this.H = (ImageView) view.findViewById(R.id.f165778dh1);
            this.I = (NumberCheckBox) view.findViewById(R.id.axc);
            this.J = (ImageView) view.findViewById(R.id.dhu);
            View findViewById3 = view.findViewById(R.id.xsh);
            this.K = (ImageView) view.findViewById(R.id.f165779dh2);
            this.L = (NumberCheckBox) view.findViewById(R.id.axd);
            this.M = (ImageView) view.findViewById(R.id.dhv);
            if (QQTheme.isNowThemeIsNight()) {
                findViewById.setBackgroundResource(R.drawable.qui_common_overlay_light_bg);
                findViewById2.setBackgroundResource(R.drawable.qui_common_overlay_light_bg);
                findViewById3.setBackgroundResource(R.drawable.qui_common_overlay_light_bg);
            }
            ImageView[] imageViewArr = {this.E, this.H, this.K};
            this.N = imageViewArr;
            for (ImageView imageView : imageViewArr) {
                imageView.setOnClickListener(this);
            }
            this.P = new NumberCheckBox[]{this.F, this.I, this.L};
            this.Q = new ImageView[]{this.G, this.J, this.M};
        }

        void l(g gVar) {
            this.R = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i("picOnClick.1", 2, "v.getId: " + view.getId() + " itemView.getTag: " + this.itemView.getTag());
                }
                g gVar = this.R;
                if (gVar != null) {
                    gVar.a(((Integer) this.itemView.getTag()).intValue(), view.getId());
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public q(QQAppInterface qQAppInterface, EmoticonGroupStoreFragment emoticonGroupStoreFragment, int i3, View view, ViewPager viewPager, Button button, LifecycleCoroutineScope lifecycleCoroutineScope) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, emoticonGroupStoreFragment, Integer.valueOf(i3), view, viewPager, button, lifecycleCoroutineScope);
            return;
        }
        this.F = new HashMap();
        this.I = new HashMap();
        this.J = new HashMap();
        this.K = new TreeMap();
        this.N = -1;
        this.P = 1;
        this.f182166c0 = new c();
        this.f182167m = qQAppInterface;
        this.Z = lifecycleCoroutineScope;
        this.D = emoticonGroupStoreFragment;
        this.C = emoticonGroupStoreFragment.getQBaseActivity();
        this.G = i3;
        this.Q = view;
        this.R = (Button) view.findViewById(R.id.aht);
        this.S = (ImageView) this.Q.findViewById(R.id.dgg);
        this.T = (TextView) this.Q.findViewById(R.id.kdk);
        this.U = viewPager;
        this.H = LayoutInflater.from(this.C);
        o oVar = new o(this.f182167m, this.C, lifecycleCoroutineScope, this.U);
        this.V = oVar;
        this.U.setAdapter(oVar);
        this.U.setOnPageChangeListener(new a());
        this.W = button;
        this.X = (IEmoticonFromGroupDBManagerService) qQAppInterface.getRuntimeService(IEmoticonFromGroupDBManagerService.class);
        com.tencent.mobileqq.emosm.favroaming.l lVar = ((ao) qQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308430h;
        this.Y = lVar;
        lVar.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(int i3, int i16) {
        int i17;
        b bVar;
        QQCustomDialog createCustomDialog;
        if (i16 == R.id.f165777dh0) {
            i17 = 0;
        } else if (i16 == R.id.f165778dh1) {
            i17 = 1;
        } else if (i16 == R.id.f165779dh2) {
            i17 = 2;
        } else {
            i17 = -1;
        }
        EmoticonFromGroupEntity emoticonFromGroupEntity = this.K.get(Integer.valueOf(i3)).get(i17);
        if (this.M) {
            int i18 = emoticonFromGroupEntity.status;
            if (-1 != i18) {
                if (i18 != 0) {
                    this.D.mStoreContent.remove(emoticonFromGroupEntity);
                    emoticonFromGroupEntity.status = -1;
                    for (EmoticonFromGroupEntity emoticonFromGroupEntity2 : this.D.mStoreContent) {
                        int i19 = emoticonFromGroupEntity2.status;
                        if (i19 > i18) {
                            emoticonFromGroupEntity2.status = i19 - 1;
                        }
                    }
                    notifyDataSetChanged();
                }
            } else if (this.X.getCountOfSpare() <= this.D.mStoreContent.size()) {
                QLog.d("GroupEmoUI.PicSelectAdapter", 2, "onUploadPicByPreview slimit=1000 nlimit=500 max=" + FavEmoConstant.FAV_LOCAL_MAX_COUNT + " spare=" + this.X.getCountOfSpare());
                int i26 = FavEmoConstant.FAV_LOCAL_MAX_COUNT;
                if (1000 == i26) {
                    QQToast.makeText(this.C, FavEmoConstant.getAddFavEmoOverLimitTips(), 0).show(R.dimen.title_bar_height);
                } else if (500 == i26 && (createCustomDialog = DialogUtil.createCustomDialog(this.C, 0, HardCodeUtil.qqStr(R.string.p6y), this.C.getString(R.string.f170071f1), HardCodeUtil.qqStr(R.string.j6l), HardCodeUtil.qqStr(R.string.f172291p71), bVar, (bVar = new b()))) != null) {
                    createCustomDialog.show();
                }
            } else if (20 > this.D.mStoreContent.size()) {
                this.D.mStoreContent.add(emoticonFromGroupEntity);
                emoticonFromGroupEntity.status = this.D.mStoreContent.size();
                notifyDataSetChanged();
            } else {
                QQToast.makeText(this.C, "\u5355\u6b21\u6700\u591a\u6536\u85cf20\u4e2a\u8868\u60c5\u54e6~", 0).show(R.dimen.title_bar_height);
            }
            if (this.D.mStoreContent.size() > 0) {
                this.W.setTextColor(Color.parseColor("#FFFFFFFF"));
                this.W.setBackgroundDrawable(this.C.getResources().getDrawable(R.drawable.a97));
                this.W.setEnabled(true);
                return;
            } else {
                this.W.setTextColor(Color.parseColor("#FFBFBFBF"));
                this.W.setBackgroundDrawable(this.C.getResources().getDrawable(R.drawable.a98));
                this.W.setEnabled(false);
                return;
            }
        }
        v0(emoticonFromGroupEntity, i17, i3);
        this.f182165b0.g(emoticonFromGroupEntity.msgElement);
    }

    private void r0() {
        int i3;
        this.I.put(0, 3);
        int i16 = 1;
        for (Map.Entry<String, List<EmoticonFromGroupEntity>> entry : this.E.entrySet()) {
            String key = entry.getKey();
            this.J.put(Integer.valueOf(i16), key);
            int i17 = i16 + 1;
            this.I.put(Integer.valueOf(i16), 0);
            List<EmoticonFromGroupEntity> value = entry.getValue();
            int size = value.size();
            int ceil = (int) Math.ceil(size / 3.0d);
            int i18 = 0;
            int i19 = 0;
            while (i18 < ceil) {
                ArrayList arrayList = new ArrayList();
                int i26 = 0;
                while (true) {
                    i3 = i19 + i26;
                    if (i3 < size && i26 < 3) {
                        arrayList.add(value.get(i3));
                        i26++;
                    }
                }
                this.J.put(Integer.valueOf(i17), key);
                this.K.put(Integer.valueOf(i17), arrayList);
                this.I.put(Integer.valueOf(i17), 1);
                i18++;
                i17++;
                i19 = i3;
            }
            i16 = i17;
        }
    }

    private void v0(EmoticonFromGroupEntity emoticonFromGroupEntity, int i3, int i16) {
        QLog.d("GroupEmoUI.PicSelectAdapter", 2, "showPreview:" + emoticonFromGroupEntity);
        AbstractGifImage.resumeAll();
        w0(emoticonFromGroupEntity);
        int i17 = emoticonFromGroupEntity.status;
        if (-1 != i17) {
            if (i17 == 0) {
                this.R.setText(HardCodeUtil.qqStr(R.string.p6v));
                this.R.setTextColor(Color.parseColor("#FFBBBBBB"));
                this.R.setBackgroundDrawable(this.C.getResources().getDrawable(R.drawable.a98));
                this.R.setEnabled(false);
            }
        } else {
            this.R.setText(HardCodeUtil.qqStr(R.string.p6w));
            this.R.setTextColor(Color.parseColor("#FFFFFFFF"));
            this.R.setBackgroundDrawable(this.C.getResources().getDrawable(R.drawable.a97));
            this.R.setEnabled(true);
        }
        if (this.K.containsKey(Integer.valueOf(i16))) {
            if (this.D.titleRoot != this.Q.getParent()) {
                this.D.titleRoot.addView(this.Q);
                this.D.enableFlingRight(false);
            }
            int i18 = 0;
            for (int i19 = 0; i19 < i16; i19++) {
                if (this.K.containsKey(Integer.valueOf(i19))) {
                    i18 += this.K.get(Integer.valueOf(i19)).size();
                }
            }
            this.U.setCurrentItem(i18 + i3, false);
        }
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickPreview", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(EmoticonFromGroupEntity emoticonFromGroupEntity) {
        Bitmap bitmap;
        String str;
        int i3 = emoticonFromGroupEntity.fromType;
        if (2 == i3) {
            bitmap = this.f182167m.getFaceBitmap(4, emoticonFromGroupEntity.troopUin, (byte) 2, false, (byte) 1, 0);
            str = ac.g0(this.f182167m, emoticonFromGroupEntity.troopUin, true);
        } else if (3000 == i3) {
            bitmap = this.f182167m.getFaceBitmap(101, emoticonFromGroupEntity.troopUin, (byte) 3, false, (byte) 1, 0);
            str = ac.p(this.f182167m, this.C, emoticonFromGroupEntity.troopUin);
        } else {
            bitmap = null;
            str = null;
        }
        this.S.setImageBitmap(bitmap);
        this.T.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(EmoticonFromGroupEntity emoticonFromGroupEntity) {
        if (emoticonFromGroupEntity.status == 0) {
            this.R.setText(HardCodeUtil.qqStr(R.string.f172292p72));
            this.R.setTextColor(Color.parseColor("#FFBBBBBB"));
            this.R.setBackgroundDrawable(this.C.getResources().getDrawable(R.drawable.a98));
            this.R.setEnabled(false);
            return;
        }
        this.R.setText(HardCodeUtil.qqStr(R.string.f172290p70));
        this.R.setTextColor(Color.parseColor("#FFFFFFFF"));
        this.R.setBackgroundDrawable(this.C.getResources().getDrawable(R.drawable.a97));
        this.R.setEnabled(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        Map<String, List<EmoticonFromGroupEntity>> map = this.E;
        int i3 = 0;
        if (map == null) {
            return 0;
        }
        int size = map.size();
        Iterator<Map.Entry<String, List<EmoticonFromGroupEntity>>> it = this.E.entrySet().iterator();
        while (it.hasNext()) {
            i3 += (int) Math.ceil(it.next().getValue().size() / 3.0d);
        }
        return size + i3 + 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, i3)).intValue();
        }
        if (i3 == getItemCount() - 1) {
            return 2;
        }
        return this.I.get(Integer.valueOf(i3)).intValue();
    }

    public String o0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        return this.F.get(this.J.get(Integer.valueOf(i3)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) viewHolder, i3);
            return;
        }
        if (viewHolder instanceof h) {
            h hVar = (h) viewHolder;
            int size = this.K.get(Integer.valueOf(i3)).size();
            for (int i16 = 0; i16 < 3; i16++) {
                RelativeLayout relativeLayout = (RelativeLayout) hVar.N[i16].getParent();
                if (i16 < size) {
                    relativeLayout.setVisibility(0);
                    EmoticonFromGroupEntity emoticonFromGroupEntity = this.K.get(Integer.valueOf(i3)).get(i16);
                    ExtensionsKt.c(emoticonFromGroupEntity, this.Y, hVar.N[i16], 65537, this.G, this.Z);
                    ImageView imageView = hVar.N[i16];
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("\u8868\u60c5");
                    int i17 = this.P;
                    this.P = i17 + 1;
                    sb5.append(i17);
                    imageView.setContentDescription(sb5.toString());
                    int i18 = emoticonFromGroupEntity.status;
                    this.N = i18;
                    if (i18 == 0) {
                        hVar.P[i16].setVisibility(4);
                        hVar.Q[i16].setVisibility(0);
                        viewHolder.itemView.setClickable(false);
                    } else if (this.L) {
                        hVar.Q[i16].setVisibility(4);
                        if (this.N > 0) {
                            hVar.P[i16].setVisibility(0);
                            hVar.P[i16].setCheckedNumber(this.N);
                        } else {
                            hVar.P[i16].setChecked(false);
                            hVar.P[i16].setVisibility(0);
                        }
                    } else {
                        hVar.P[i16].setVisibility(4);
                        hVar.Q[i16].setVisibility(4);
                    }
                } else {
                    relativeLayout.setVisibility(4);
                }
            }
            viewHolder.itemView.setTag(Integer.valueOf(i3));
            return;
        }
        if (viewHolder instanceof d) {
            ((d) viewHolder).E.setText(this.F.get(this.J.get(Integer.valueOf(i3))));
            return;
        }
        if (viewHolder instanceof f) {
            ((f) viewHolder).E.setText("\u4ec5\u4fdd\u7559\u6700\u65b0\u8868\u60c5\uff0c\n\u66f4\u591a\u8868\u60c5\u8bf7\u5728\u6d88\u606f\u8bb0\u5f55\u4e2d\u67e5\u627e\u54e6\uff5e");
            return;
        }
        if (viewHolder instanceof e) {
            e eVar = (e) viewHolder;
            if (TextUtils.isEmpty(this.f182164a0)) {
                eVar.E.setText(R.string.rfk);
            } else {
                eVar.E.setText(this.f182164a0);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        RecyclerView.ViewHolder viewHolder;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewGroup, i3);
        }
        if (QLog.isColorLevel()) {
            QLog.i("GroupEmoUI.PicSelectAdapter", 2, "view type: " + i3);
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return null;
                    }
                    viewHolder = new e(this.H.inflate(R.layout.hgh, viewGroup, false));
                } else {
                    viewHolder = new f(this.H.inflate(R.layout.f168953bc1, viewGroup, false));
                }
            } else {
                View inflate = this.H.inflate(R.layout.bby, viewGroup, false);
                inflate.setLayoutParams((RecyclerView.LayoutParams) inflate.getLayoutParams());
                h hVar = new h(inflate);
                hVar.l(this.f182166c0);
                viewHolder = hVar;
            }
        } else {
            viewHolder = new d(this.H.inflate(R.layout.bbx, viewGroup, false));
        }
        return viewHolder;
    }

    public void q0(Map<String, List<EmoticonFromGroupEntity>> map, List<EmoticonFromGroupEntity> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) map, (Object) list);
            return;
        }
        this.E = map;
        this.K.clear();
        this.J.clear();
        this.I.clear();
        r0();
        this.F.clear();
        for (Map.Entry<String, List<EmoticonFromGroupEntity>> entry : map.entrySet()) {
            String key = entry.getKey();
            this.F.put(key, this.Y.e(key, entry.getValue().size(), "  "));
        }
        notifyDataSetChanged();
        this.V.setData(list);
        this.V.notifyDataSetChanged();
    }

    public boolean s0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, z16)).booleanValue();
        }
        boolean z17 = this.M;
        this.M = z16;
        return z17;
    }

    public void t0(com.tencent.mobileqq.activity.emogroupstore.report.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.f182165b0 = aVar;
        }
    }

    public void u0(SpannableString spannableString) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) spannableString);
        } else if (!TextUtils.equals(spannableString, this.f182164a0)) {
            this.f182164a0 = spannableString;
            notifyItemChanged(0);
        }
    }
}
