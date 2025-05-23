package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class DiscussionMemberActivity extends IphoneTitleBarActivity implements AdapterView.OnItemClickListener, View.OnTouchListener, IndexView.b, PinnedDividerListView.b, View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private final String f175614a0;

    /* renamed from: b0, reason: collision with root package name */
    private final int f175615b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f175616c0;

    /* renamed from: d0, reason: collision with root package name */
    private i f175617d0;

    /* renamed from: e0, reason: collision with root package name */
    PinnedDividerListView f175618e0;

    /* renamed from: f0, reason: collision with root package name */
    private IndexView f175619f0;

    /* renamed from: g0, reason: collision with root package name */
    List<h> f175620g0;

    /* renamed from: h0, reason: collision with root package name */
    private List<h> f175621h0;

    /* renamed from: i0, reason: collision with root package name */
    private EditText f175622i0;

    /* renamed from: j0, reason: collision with root package name */
    private View f175623j0;

    /* renamed from: k0, reason: collision with root package name */
    View f175624k0;

    /* renamed from: l0, reason: collision with root package name */
    View f175625l0;

    /* renamed from: m0, reason: collision with root package name */
    EditText f175626m0;

    /* renamed from: n0, reason: collision with root package name */
    private ImageButton f175627n0;

    /* renamed from: o0, reason: collision with root package name */
    private View f175628o0;

    /* renamed from: p0, reason: collision with root package name */
    private RelativeLayout f175629p0;

    /* renamed from: q0, reason: collision with root package name */
    XListView f175630q0;

    /* renamed from: r0, reason: collision with root package name */
    k f175631r0;

    /* renamed from: s0, reason: collision with root package name */
    private View f175632s0;

    /* renamed from: t0, reason: collision with root package name */
    private String f175633t0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TranslateAnimation f175640d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Dialog f175641e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ TranslateAnimation f175642f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f175643h;

        a(TranslateAnimation translateAnimation, Dialog dialog, TranslateAnimation translateAnimation2, int i3) {
            this.f175640d = translateAnimation;
            this.f175641e = dialog;
            this.f175642f = translateAnimation2;
            this.f175643h = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DiscussionMemberActivity.this, translateAnimation, dialog, translateAnimation2, Integer.valueOf(i3));
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            if (animation == this.f175640d) {
                this.f175641e.show();
                DiscussionMemberActivity.this.f175624k0.setAnimation(null);
                DiscussionMemberActivity.this.f175623j0.setVisibility(8);
            } else if (animation == this.f175642f) {
                DiscussionMemberActivity.this.f175624k0.setAnimation(null);
                DiscussionMemberActivity.this.f175624k0.offsetTopAndBottom(this.f175643h);
                DiscussionMemberActivity.this.f175624k0.requestLayout();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionMemberActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
                return;
            }
            k kVar = DiscussionMemberActivity.this.f175631r0;
            if (kVar != null) {
                kVar.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionMemberActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                DiscussionMemberActivity.this.f175626m0.setText("");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Dialog f175647d;

        d(Dialog dialog) {
            this.f175647d = dialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionMemberActivity.this, (Object) dialog);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                this.f175647d.cancel();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Dialog f175649d;

        e(Dialog dialog) {
            this.f175649d = dialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionMemberActivity.this, (Object) dialog);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                this.f175649d.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ InputMethodManager f175651d;

        f(InputMethodManager inputMethodManager) {
            this.f175651d = inputMethodManager;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionMemberActivity.this, (Object) inputMethodManager);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            this.f175651d.hideSoftInputFromWindow(view.getWindowToken(), 0);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements AdapterView.OnItemClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Dialog f175653d;

        g(Dialog dialog) {
            this.f175653d = dialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionMemberActivity.this, (Object) dialog);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
            } else {
                DiscussionMemberActivity.this.J2(view);
                this.f175653d.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f175655a;

        /* renamed from: b, reason: collision with root package name */
        public String f175656b;

        /* renamed from: c, reason: collision with root package name */
        public String f175657c;

        /* renamed from: d, reason: collision with root package name */
        public String f175658d;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionMemberActivity.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private class i extends com.tencent.mobileqq.adapter.e {
        static IPatchRedirector $redirector_;
        private LinkedHashMap<String, List<h>> D;
        private int[] E;
        private String[] F;

        public i() {
            super(DiscussionMemberActivity.this, DiscussionMemberActivity.this.app, DiscussionMemberActivity.this.f175618e0, true);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionMemberActivity.this);
                return;
            }
            this.D = new LinkedHashMap<>();
            this.E = new int[0];
            this.F = new String[0];
            g();
        }

        private void g() {
            char c16;
            int i3;
            String str;
            this.D.clear();
            Iterator<h> it = DiscussionMemberActivity.this.f175620g0.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                i3 = 0;
                String str2 = "#";
                if (!hasNext) {
                    break;
                }
                h next = it.next();
                String str3 = next.f175657c;
                if (str3 == null || str3.length() == 0) {
                    str = "#";
                } else {
                    str = next.f175657c.substring(0, 1);
                }
                char charAt = str.charAt(0);
                if (('A' <= charAt && charAt <= 'Z') || ('a' <= charAt && charAt <= 'z')) {
                    str2 = str.toUpperCase();
                }
                if (this.D.get(str2) == null) {
                    this.D.put(str2, new ArrayList());
                }
                this.D.get(str2).add(next);
            }
            LinkedHashMap<String, List<h>> linkedHashMap = this.D;
            this.D = new LinkedHashMap<>();
            for (c16 = EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET; c16 <= 'Z'; c16 = (char) (c16 + 1)) {
                if (linkedHashMap.get(String.valueOf(c16)) != null) {
                    this.D.put(String.valueOf(c16), linkedHashMap.get(String.valueOf(c16)));
                }
            }
            if (linkedHashMap.get("#") != null) {
                this.D.put("#", linkedHashMap.get("#"));
            }
            linkedHashMap.clear();
            int[] iArr = new int[this.D.keySet().size()];
            this.E = iArr;
            this.F = new String[iArr.length];
            Iterator<String> it5 = this.D.keySet().iterator();
            int[] iArr2 = this.E;
            if (iArr2.length == 0) {
                return;
            }
            iArr2[0] = 0;
            int i16 = 1;
            while (true) {
                int[] iArr3 = this.E;
                if (i16 >= iArr3.length) {
                    break;
                }
                iArr3[i16] = iArr3[i16] + iArr3[i16 - 1] + this.D.get(it5.next()).size() + 1;
                i16++;
            }
            Iterator<String> it6 = this.D.keySet().iterator();
            while (it6.hasNext()) {
                this.F[i3] = it6.next();
                i3++;
            }
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public void configDividerView(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) view, i3);
                return;
            }
            int binarySearch = Arrays.binarySearch(this.E, i3);
            if (binarySearch < 0) {
                binarySearch = (-(binarySearch + 1)) - 1;
            }
            ((TextView) view).setText(this.F[binarySearch]);
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            int[] iArr = this.E;
            if (iArr.length == 0) {
                return 0;
            }
            return iArr[iArr.length - 1] + this.D.get(this.F[r2.length - 1]).size() + 1;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public int getDividerLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return R.layout.f168254qf;
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            int binarySearch = Arrays.binarySearch(this.E, i3);
            if (binarySearch >= 0) {
                return null;
            }
            return this.D.get(this.F[(-(binarySearch + 1)) - 1]).get((i3 - this.E[r0]) - 1);
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return 0L;
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                int binarySearch = Arrays.binarySearch(this.E, i3);
                if (view == null) {
                    view = DiscussionMemberActivity.this.getLayoutInflater().inflate(R.layout.f167916m9, viewGroup, false);
                    com.tencent.mobileqq.troop.memberlist.b bVar = new com.tencent.mobileqq.troop.memberlist.b();
                    view.setTag(bVar);
                    bVar.f297804i = (RelativeLayout) view.findViewById(R.id.icx);
                    bVar.f297805m = (TextView) view.findViewById(R.id.k8u);
                    bVar.f187212f = (ImageView) view.findViewById(R.id.dvo);
                    bVar.C = (TextView) view.findViewById(R.id.tv_name);
                }
                com.tencent.mobileqq.troop.memberlist.b bVar2 = (com.tencent.mobileqq.troop.memberlist.b) view.getTag();
                if (binarySearch < 0) {
                    int i16 = (-(binarySearch + 1)) - 1;
                    h hVar = this.D.get(this.F[i16]).get((i3 - this.E[i16]) - 1);
                    bVar2.f297804i.setVisibility(0);
                    bVar2.f297805m.setVisibility(8);
                    bVar2.f187212f.setImageBitmap(c(hVar.f175655a, 1));
                    bVar2.C.setText(hVar.f175656b);
                    bVar2.f187210d = hVar.f175655a;
                } else {
                    bVar2.f297804i.setVisibility(8);
                    bVar2.f297805m.setVisibility(0);
                    bVar2.f297805m.setText(String.valueOf(this.F[binarySearch]));
                }
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        public int h(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str)).intValue();
            }
            if (this.F != null) {
                int i3 = 0;
                while (true) {
                    String[] strArr = this.F;
                    if (i3 < strArr.length) {
                        if (strArr[i3].equals(str)) {
                            break;
                        }
                        i3++;
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                if (i3 >= 0) {
                    return this.E[i3];
                }
            }
            return -1;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public boolean isDividerView(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, i3)).booleanValue();
            }
            if (Arrays.binarySearch(this.E, i3) >= 0) {
                return true;
            }
            return false;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this);
            } else {
                g();
                super.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class j implements Comparator<h> {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionMemberActivity.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(h hVar, h hVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) hVar, (Object) hVar2)).intValue();
            }
            return hVar.f175657c.compareToIgnoreCase(hVar2.f175657c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class k extends com.tencent.mobileqq.adapter.j {
        static IPatchRedirector $redirector_;
        private List<h> F;

        public k(List<h> list) {
            super(DiscussionMemberActivity.this, DiscussionMemberActivity.this.app, DiscussionMemberActivity.this.f175630q0, 1, true);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionMemberActivity.this, (Object) list);
            } else {
                this.F = list;
            }
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            List<h> list = this.F;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            if (i3 >= 0 && i3 < this.F.size()) {
                return this.F.get(i3);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            m mVar;
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    view = DiscussionMemberActivity.this.getLayoutInflater().inflate(R.layout.f167916m9, viewGroup, false);
                    mVar = new m();
                    mVar.f187212f = (ImageView) view.findViewById(R.id.dvo);
                    mVar.E = (TextView) view.findViewById(R.id.tv_name);
                    view.setTag(mVar);
                } else {
                    mVar = (m) view.getTag();
                }
                h hVar = (h) getItem(i3);
                if (hVar != null) {
                    String str = hVar.f175656b;
                    if (str != null && !"".equals(str.trim())) {
                        mVar.E.setText(hVar.f175656b);
                    } else {
                        mVar.E.setText(hVar.f175655a);
                    }
                    String str2 = hVar.f175655a;
                    mVar.f187210d = str2;
                    mVar.f187212f.setImageBitmap(c(1, str2));
                }
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class l implements TextWatcher {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionMemberActivity.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) editable);
            } else {
                DiscussionMemberActivity.this.refreshSearchResultList(DiscussionMemberActivity.this.f175626m0.getText().toString().trim());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static class m extends com.tencent.mobileqq.troop.memberlist.b {
        static IPatchRedirector $redirector_;
        public TextView E;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public DiscussionMemberActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f175614a0 = "DiscussionMemberActivity";
        this.f175615b0 = 1;
        this.f175620g0 = new ArrayList();
        this.f175621h0 = new ArrayList();
    }

    private void H2() {
        ArrayList<DiscussionMemberInfo> m3 = ((com.tencent.mobileqq.app.n) this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).m(this.f175616c0);
        if (m3 != null) {
            this.f175620g0.clear();
            for (DiscussionMemberInfo discussionMemberInfo : m3) {
                if (discussionMemberInfo.memberUin.equals(this.app.getCurrentAccountUin())) {
                    this.f175633t0 = com.tencent.mobileqq.utils.ac.Y(this.app, discussionMemberInfo);
                } else {
                    h hVar = new h();
                    hVar.f175655a = discussionMemberInfo.memberUin;
                    String m16 = com.tencent.mobileqq.utils.ac.m(discussionMemberInfo, this.app);
                    hVar.f175656b = m16;
                    hVar.f175658d = ChnToSpell.d(m16, 1);
                    hVar.f175657c = ChnToSpell.d(hVar.f175656b, 2);
                    this.f175620g0.add(hVar);
                }
            }
        }
    }

    private void I2() {
        ReportDialog reportDialog = new ReportDialog(this);
        reportDialog.setCanceledOnTouchOutside(true);
        reportDialog.requestWindowFeature(1);
        reportDialog.getWindow().setSoftInputMode(36);
        reportDialog.setContentView(R.layout.bxb);
        WindowManager.LayoutParams attributes = reportDialog.getWindow().getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.width = -1;
        attributes.windowAnimations = android.R.style.Animation;
        attributes.gravity = 51;
        reportDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
        int height = this.f175623j0.getHeight();
        float f16 = -height;
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, f16);
        translateAnimation.setDuration(300L);
        translateAnimation.setFillAfter(true);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, f16, 0.0f);
        translateAnimation2.setDuration(300L);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        a aVar = new a(translateAnimation, reportDialog, translateAnimation2, height);
        translateAnimation.setAnimationListener(aVar);
        translateAnimation2.setAnimationListener(aVar);
        this.f175624k0.startAnimation(translateAnimation);
        b bVar = new b();
        addObserver(bVar);
        reportDialog.setOnDismissListener(new DialogInterface.OnDismissListener(height, translateAnimation2, inputMethodManager, bVar) { // from class: com.tencent.mobileqq.activity.DiscussionMemberActivity.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f175634d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ TranslateAnimation f175635e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ InputMethodManager f175636f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.avatar.observer.a f175637h;

            {
                this.f175634d = height;
                this.f175635e = translateAnimation2;
                this.f175636f = inputMethodManager;
                this.f175637h = bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, DiscussionMemberActivity.this, Integer.valueOf(height), translateAnimation2, inputMethodManager, bVar);
                }
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                } else {
                    DiscussionMemberActivity.this.f175624k0.getHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.DiscussionMemberActivity.3.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            DiscussionMemberActivity.this.f175624k0.offsetTopAndBottom(-anonymousClass3.f175634d);
                            DiscussionMemberActivity.this.f175623j0.setVisibility(0);
                            AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                            DiscussionMemberActivity.this.f175624k0.startAnimation(anonymousClass32.f175635e);
                            AnonymousClass3 anonymousClass33 = AnonymousClass3.this;
                            anonymousClass33.f175636f.hideSoftInputFromWindow(DiscussionMemberActivity.this.getWindow().peekDecorView().getWindowToken(), 0);
                            AnonymousClass3 anonymousClass34 = AnonymousClass3.this;
                            DiscussionMemberActivity.this.removeObserver(anonymousClass34.f175637h);
                        }
                    }, 150L);
                }
            }
        });
        EditText editText = (EditText) reportDialog.findViewById(R.id.et_search_keyword);
        this.f175626m0 = editText;
        editText.addTextChangedListener(new l());
        this.f175626m0.setSelection(0);
        this.f175626m0.requestFocus();
        ImageButton imageButton = (ImageButton) reportDialog.findViewById(R.id.ib_clear_text);
        this.f175627n0 = imageButton;
        imageButton.setOnClickListener(new c());
        Button button = (Button) reportDialog.findViewById(R.id.btn_cancel_search);
        button.setVisibility(0);
        button.setOnClickListener(new d(reportDialog));
        this.f175628o0 = reportDialog.findViewById(R.id.f166412fa0);
        RelativeLayout relativeLayout = (RelativeLayout) reportDialog.findViewById(R.id.result_layout);
        this.f175629p0 = relativeLayout;
        relativeLayout.setOnClickListener(new e(reportDialog));
        XListView xListView = (XListView) reportDialog.findViewById(R.id.searchList);
        this.f175630q0 = xListView;
        xListView.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_texture));
        this.f175630q0.setDividerHeight(0);
        this.f175621h0.clear();
        k kVar = new k(this.f175621h0);
        this.f175631r0 = kVar;
        this.f175630q0.setAdapter((ListAdapter) kVar);
        this.f175630q0.setOnTouchListener(new f(inputMethodManager));
        this.f175630q0.setOnItemClickListener(new g(reportDialog));
    }

    private void initUI() {
        this.f175618e0 = (PinnedDividerListView) findViewById(R.id.atu);
        this.f175619f0 = (IndexView) findViewById(R.id.djh);
        this.f175618e0.setSelector(R.color.ajr);
        this.f175618e0.setOnItemClickListener(this);
        this.f175618e0.setOnLayoutListener(this);
        this.f175619f0.setIndex(new String[]{"$", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "T", "U", "V", "W", "X", "Y", "Z", "#"});
        this.f175619f0.setOnIndexChangedListener(this);
        View findViewById = findViewById(R.id.rlCommenTitle);
        this.f175623j0 = findViewById;
        this.f175624k0 = (View) findViewById.getParent();
        View findViewById2 = findViewById(R.id.im8);
        this.f175625l0 = findViewById2;
        findViewById2.setBackgroundResource(R.drawable.bg_texture);
        setTitle(HardCodeUtil.qqStr(R.string.lnz));
        RelativeLayout relativeLayout = (RelativeLayout) getLayoutInflater().inflate(R.layout.search_box, (ViewGroup) this.f175618e0, false);
        relativeLayout.setPadding(0, 0, 40, 0);
        EditText editText = (EditText) relativeLayout.findViewById(R.id.et_search_keyword);
        this.f175622i0 = editText;
        editText.setFocusable(false);
        this.f175622i0.setOnTouchListener(this);
        ((Button) relativeLayout.findViewById(R.id.btn_cancel_search)).setVisibility(8);
        this.f175618e0.addHeaderView(relativeLayout);
        this.f175632s0 = getLayoutInflater().inflate(R.layout.f167916m9, (ViewGroup) this.f175618e0, false);
        com.tencent.mobileqq.troop.memberlist.b bVar = new com.tencent.mobileqq.troop.memberlist.b();
        bVar.f187210d = this.app.getCurrentAccountUin();
        ImageView imageView = (ImageView) this.f175632s0.findViewById(R.id.dvo);
        bVar.f187212f = imageView;
        QQAppInterface qQAppInterface = this.app;
        imageView.setBackgroundDrawable(FaceDrawable.getUserFaceDrawable(qQAppInterface, qQAppInterface.getCurrentAccountUin(), (byte) 3));
        bVar.C = (TextView) this.f175632s0.findViewById(R.id.tv_name);
        String currentNickname = this.app.getCurrentNickname();
        TextView textView = bVar.C;
        if (currentNickname == null || currentNickname.trim().length() <= 0) {
            currentNickname = this.app.getCurrentAccountUin();
        }
        textView.setText(currentNickname);
        this.f175632s0.setTag(bVar);
        this.f175632s0.setOnClickListener(this);
        this.f175618e0.addHeaderView(this.f175632s0);
    }

    void J2(View view) {
        String str;
        if (view == null) {
            QLog.d("DiscussionMemberActivity", 1, "the view is null, return");
            return;
        }
        com.tencent.mobileqq.troop.memberlist.b bVar = (com.tencent.mobileqq.troop.memberlist.b) view.getTag();
        if (bVar != null && (str = bVar.f187210d) != null) {
            if (str.equals(this.app.getCurrentAccountUin())) {
                AllInOne allInOne = new AllInOne(str, 0);
                allInOne.lastActivity = 5;
                ProfileUtils.openProfileCardForResult(this, allInOne, 1);
            } else {
                if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "DiscussionMemberActivity")) {
                    AllInOne allInOne2 = new AllInOne(str, 1);
                    allInOne2.nickname = com.tencent.mobileqq.utils.ac.Q(this.app, str, 0);
                    allInOne2.lastActivity = 5;
                    ProfileUtils.openProfileCardForResult(this, allInOne2, 1);
                    return;
                }
                AllInOne allInOne3 = new AllInOne(str, 46);
                allInOne3.nickname = com.tencent.mobileqq.utils.ac.Q(this.app, str, 0);
                allInOne3.preWinUin = str;
                allInOne3.preWinType = 3000;
                allInOne3.discussUin = this.f175616c0;
                allInOne3.lastActivity = 5;
                ProfileUtils.openProfileCardForResult(this, allInOne3, 1);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else if (-1 == i16 && i16 == 1) {
            this.f175617d0.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        super.setContentView(R.layout.f169084by4);
        this.f175616c0 = getIntent().getStringExtra("uin");
        initUI();
        H2();
        ((com.tencent.mobileqq.troop.memberlist.b) this.f175632s0.getTag()).C.setText(this.f175633t0);
        i iVar = new i();
        this.f175617d0 = iVar;
        this.f175618e0.setAdapter((ListAdapter) iVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f175617d0.destroy();
            super.doOnDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.doOnStart();
            getWindow().setSoftInputMode(48);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else if (view == this.f175632s0) {
            J2(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.widget.IndexView.b
    public void onIndexChanged(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        if ("$".equals(str)) {
            this.f175618e0.setSelection(0);
            return;
        }
        int h16 = this.f175617d0.h(str);
        if (h16 != -1) {
            PinnedDividerListView pinnedDividerListView = this.f175618e0;
            pinnedDividerListView.setSelection(h16 + pinnedDividerListView.getHeaderViewsCount());
        }
    }

    @Override // com.tencent.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            J2(view);
        }
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.b
    public void onLayout(View view, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else if (this.f175618e0.getFirstVisiblePosition() > 0 || (this.f175618e0.getFirstVisiblePosition() == 0 && this.f175618e0.getChildCount() < this.f175617d0.getCount() + this.f175618e0.getHeaderViewsCount())) {
            this.f175619f0.setVisibility(0);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        if (motionEvent.getAction() == 1) {
            I2();
        }
        return true;
    }

    void refreshSearchResultList(String str) {
        this.f175621h0.clear();
        if (!str.equals("") && str.trim().length() != 0) {
            this.f175627n0.setVisibility(0);
            this.f175630q0.setVisibility(0);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (h hVar : this.f175620g0) {
                if (hVar != null) {
                    String lowerCase = str.toLowerCase();
                    if (!hVar.f175656b.equalsIgnoreCase(str) && !hVar.f175655a.equals(str) && !hVar.f175658d.equalsIgnoreCase(lowerCase) && !hVar.f175657c.equalsIgnoreCase(lowerCase)) {
                        if (hVar.f175656b.toLowerCase().indexOf(str) != 0 && hVar.f175655a.indexOf(str) != 0 && hVar.f175657c.toLowerCase().indexOf(lowerCase) != 0 && hVar.f175658d.toLowerCase().indexOf(lowerCase) != 0) {
                            if (hVar.f175656b.toLowerCase().indexOf(str) > 0 || hVar.f175655a.indexOf(str) > 0 || hVar.f175657c.toLowerCase().indexOf(lowerCase) > 0 || hVar.f175658d.toLowerCase().indexOf(lowerCase) > 0) {
                                arrayList3.add(hVar);
                            }
                        } else {
                            arrayList2.add(hVar);
                        }
                    } else {
                        arrayList.add(hVar);
                    }
                }
            }
            Collections.sort(arrayList2, new j());
            this.f175621h0.addAll(arrayList);
            this.f175621h0.addAll(arrayList2);
            this.f175621h0.addAll(arrayList3);
            if (this.f175621h0.isEmpty()) {
                this.f175628o0.setVisibility(0);
            } else {
                this.f175628o0.setVisibility(8);
            }
        } else {
            this.f175627n0.setVisibility(8);
            this.f175630q0.setVisibility(8);
            this.f175628o0.setVisibility(8);
        }
        this.f175631r0.notifyDataSetChanged();
    }
}
