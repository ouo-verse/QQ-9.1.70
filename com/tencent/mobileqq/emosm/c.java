package com.tencent.mobileqq.emosm;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.EmoticonTabNtUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.CommonTabEmojiInfo;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.widget.Switch;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c extends com.tencent.mobileqq.emosm.view.b<CommonTabEmojiInfo> {
    private LruCache<String, Drawable> C;
    private Drawable D;
    private IEmoticonManagerService E;
    private a F;

    /* renamed from: m, reason: collision with root package name */
    private boolean f204228m;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z16, CommonTabEmojiInfo commonTabEmojiInfo);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        ViewGroup f204229a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f204230b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f204231c;

        /* renamed from: d, reason: collision with root package name */
        ImageView f204232d;

        /* renamed from: e, reason: collision with root package name */
        ImageView f204233e;

        /* renamed from: f, reason: collision with root package name */
        View f204234f;

        /* renamed from: g, reason: collision with root package name */
        View f204235g;

        /* renamed from: h, reason: collision with root package name */
        TextView f204236h;

        /* renamed from: i, reason: collision with root package name */
        ImageView f204237i;

        /* renamed from: j, reason: collision with root package name */
        ImageView f204238j;

        /* renamed from: k, reason: collision with root package name */
        TextView f204239k;

        /* renamed from: l, reason: collision with root package name */
        View f204240l;

        /* renamed from: m, reason: collision with root package name */
        Switch f204241m;

        public b() {
        }
    }

    public c(Context context, IEmoticonManagerService iEmoticonManagerService, List<CommonTabEmojiInfo> list) {
        super(context, list);
        this.C = new LruCache<>(30);
        this.E = iEmoticonManagerService;
        this.D = this.f204445e.getResources().getDrawable(R.drawable.cdt);
    }

    private Drawable k(EmoticonPackage emoticonPackage) {
        if (emoticonPackage == null) {
            return this.D;
        }
        if (this.C.get(emoticonPackage.epId) != null) {
            return this.C.get(emoticonPackage.epId);
        }
        Drawable m3 = e.m(2, emoticonPackage.epId);
        if (m3 != null) {
            this.C.put(emoticonPackage.epId, m3);
            return m3;
        }
        return this.D;
    }

    private Drawable l(Context context, CommonTabEmojiInfo commonTabEmojiInfo) {
        if (commonTabEmojiInfo.bottomEmojitabType != 6) {
            return this.D;
        }
        switch (commonTabEmojiInfo.epId) {
            case 1:
                return context.getDrawable(R.drawable.qui_search_selector_01);
            case 2:
                return context.getDrawable(R.drawable.j6g);
            case 3:
                return context.getDrawable(R.drawable.j6n);
            case 4:
                return context.getDrawable(R.drawable.f160633cg3);
            case 5:
                return context.getDrawable(R.drawable.j6h);
            case 6:
                return context.getDrawable(R.drawable.j6f);
            case 7:
                return context.getDrawable(R.drawable.mkt);
            default:
                return this.D;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(CommonTabEmojiInfo commonTabEmojiInfo, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        if (compoundButton.isPressed()) {
            commonTabEmojiInfo.isHide = !z16;
            a aVar = this.F;
            if (aVar != null) {
                aVar.a(z16, commonTabEmojiInfo);
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private boolean n(CommonTabEmojiInfo commonTabEmojiInfo) {
        AppRuntime peekAppRuntime;
        EmoticonTabNtUtils emoticonTabNtUtils = EmoticonTabNtUtils.INSTANCE;
        if (emoticonTabNtUtils.isMarketFace(commonTabEmojiInfo)) {
            if (emoticonTabNtUtils.isMarketMaicFace(commonTabEmojiInfo)) {
                return false;
            }
            return true;
        }
        int i3 = commonTabEmojiInfo.epId;
        if (i3 != 5) {
            if (i3 == 6) {
                return true;
            }
            if (i3 != 7 || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null || !((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(Constant.FROM_ID_START_ACTIVITY, peekAppRuntime.getLongAccountUin())) {
                return false;
            }
            return true;
        }
        boolean isMergeHotPicExperiment = emoticonTabNtUtils.isMergeHotPicExperiment();
        QLog.i("EmosmDragSortAdapter", 1, "needShowTabItem hotPic isExperiment:" + isMergeHotPicExperiment);
        return !isMergeHotPicExperiment;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        b bVar;
        int i16;
        boolean z16;
        boolean z17;
        Drawable k3;
        String str;
        if (view == null) {
            b bVar2 = new b();
            View inflate = View.inflate(this.f204445e, R.layout.f168906h84, null);
            bVar2.f204229a = (ViewGroup) inflate.findViewById(R.id.ut7);
            bVar2.f204230b = (ImageView) inflate.findViewById(R.id.bvf);
            bVar2.f204231c = (ImageView) inflate.findViewById(R.id.bvj);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.f165020bq3);
            bVar2.f204232d = imageView;
            AccessibilityUtil.c(imageView, HardCodeUtil.qqStr(R.string.f170789aa3), "");
            bVar2.f204233e = (ImageView) inflate.findViewById(R.id.f165021bq4);
            bVar2.f204236h = (TextView) inflate.findViewById(R.id.bvi);
            bVar2.f204237i = (ImageView) inflate.findViewById(R.id.bvg);
            bVar2.f204239k = (TextView) inflate.findViewById(R.id.bvk);
            bVar2.f204234f = inflate.findViewById(R.id.iqk);
            bVar2.f204235g = inflate.findViewById(R.id.kiv);
            bVar2.f204238j = (ImageView) inflate.findViewById(R.id.f7k);
            bVar2.f204240l = inflate.findViewById(R.id.f7a);
            bVar2.f204241m = (Switch) inflate.findViewById(R.id.ut8);
            inflate.setTag(bVar2);
            viewGroup.setTag(bVar2);
            inflate.setBackgroundResource(R.drawable.b7n);
            bVar = bVar2;
            view = inflate;
        } else {
            bVar = (b) view.getTag();
        }
        final CommonTabEmojiInfo commonTabEmojiInfo = (CommonTabEmojiInfo) this.f204444d.get(i3);
        if (commonTabEmojiInfo.bottomEmojitabType == 6) {
            k3 = l(view.getContext(), commonTabEmojiInfo);
            i16 = 0;
            z16 = false;
            z17 = false;
        } else {
            EmoticonPackage syncFindEmoticonPackageById = this.E.syncFindEmoticonPackageById(String.valueOf(commonTabEmojiInfo.epId));
            if (syncFindEmoticonPackageById != null) {
                i16 = syncFindEmoticonPackageById.mobileFeetype;
                z16 = syncFindEmoticonPackageById.hasSound;
                z17 = syncFindEmoticonPackageById.isNewVoiceType();
            } else {
                i16 = 0;
                z16 = false;
                z17 = false;
            }
            k3 = k(syncFindEmoticonPackageById);
        }
        if (commonTabEmojiInfo.bottomEmojitabType == 6) {
            str = this.f204445e.getString(R.string.zuv) + commonTabEmojiInfo.tabName;
        } else {
            str = commonTabEmojiInfo.tabName;
        }
        bVar.f204236h.setText(str);
        bVar.f204230b.setImageDrawable(k3);
        bVar.f204234f.setVisibility(8);
        if (z16) {
            bVar.f204237i.setVisibility(0);
            if (z17) {
                bVar.f204237i.setImageResource(R.drawable.bft);
            } else {
                bVar.f204237i.setImageResource(R.drawable.f160638ma);
            }
        } else {
            bVar.f204237i.setVisibility(8);
        }
        if (this.f204228m) {
            if (commonTabEmojiInfo.bottomEmojitabType == 6) {
                view.setContentDescription(this.f204445e.getString(R.string.zx5) + " " + str);
                bVar.f204231c.setImageResource(R.drawable.l_8);
            } else if (!c(i3)) {
                view.setContentDescription(this.f204445e.getString(R.string.b2j) + " " + str);
                bVar.f204231c.setImageResource(R.drawable.fnr);
            } else {
                view.setContentDescription(this.f204445e.getString(R.string.b29) + " " + str);
                bVar.f204231c.setImageResource(R.drawable.fns);
            }
            bVar.f204231c.setVisibility(0);
            bVar.f204232d.setVisibility(0);
            bVar.f204240l.setVisibility(8);
            bVar.f204241m.setVisibility(8);
        } else {
            view.setContentDescription(str);
            bVar.f204231c.setVisibility(8);
            bVar.f204232d.setVisibility(8);
            if (commonTabEmojiInfo.bottomEmojitabType == 6) {
                bVar.f204240l.setVisibility(8);
                bVar.f204241m.setVisibility(0);
                bVar.f204241m.setChecked(!commonTabEmojiInfo.isHide);
                bVar.f204241m.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.emosm.b
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z18) {
                        c.this.m(commonTabEmojiInfo, compoundButton, z18);
                    }
                });
            } else {
                bVar.f204240l.setVisibility(0);
                bVar.f204241m.setVisibility(8);
            }
        }
        if (i16 == 4) {
            bVar.f204238j.setVisibility(0);
            bVar.f204238j.setBackgroundDrawable(this.f204445e.getResources().getDrawable(R.drawable.cg5));
        } else if (i16 == 5) {
            bVar.f204238j.setVisibility(0);
            bVar.f204238j.setBackgroundDrawable(this.f204445e.getResources().getDrawable(R.drawable.hwd));
        } else {
            bVar.f204238j.setVisibility(8);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (n(commonTabEmojiInfo)) {
            view.setVisibility(0);
            if (layoutParams != null) {
                layoutParams.height = -2;
            } else {
                view.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            }
        } else {
            view.setVisibility(8);
            if (layoutParams != null) {
                layoutParams.height = 0;
            } else {
                view.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
            }
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    public void j() {
        this.C.evictAll();
    }

    public void o(boolean z16) {
        this.f204228m = z16;
    }

    public void p(a aVar) {
        this.F = aVar;
    }
}
