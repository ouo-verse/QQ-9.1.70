package com.tencent.mobileqq.troop.file.data;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.file.widget.ChildPressEffectRelativeLayout;
import com.tencent.mobileqq.troop.utils.RollangleImageView;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.troop.widget.PinnedHeaderIphoneTreeView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes35.dex */
public class TroopFileSearchExpandableListAdapter extends BaseExpandableListAdapter implements AbsListView.OnScrollListener, Handler.Callback, View.OnClickListener {
    protected static String L = "TroopFileSearchExpandableListAdapter";
    protected PinnedHeaderIphoneTreeView C;
    protected TroopFileTransferManager D;
    protected long E;
    protected List<o> H;
    protected List<o> I;

    /* renamed from: d, reason: collision with root package name */
    protected final int f295412d;

    /* renamed from: e, reason: collision with root package name */
    protected Activity f295413e;

    /* renamed from: f, reason: collision with root package name */
    protected QQAppInterface f295414f;

    /* renamed from: h, reason: collision with root package name */
    protected Handler f295415h;

    /* renamed from: m, reason: collision with root package name */
    protected LayoutInflater f295417m;
    protected String F = null;
    protected HashMap<o, ViewHolder> G = new HashMap<>();
    public boolean J = false;
    public boolean K = false;

    /* renamed from: i, reason: collision with root package name */
    protected Handler f295416i = new Handler(this);

    public TroopFileSearchExpandableListAdapter(Activity activity, Activity activity2, QQAppInterface qQAppInterface, long j3, PinnedHeaderIphoneTreeView pinnedHeaderIphoneTreeView, Handler handler) {
        this.f295417m = null;
        this.E = 0L;
        this.H = null;
        this.I = null;
        this.f295413e = activity;
        this.f295414f = qQAppInterface;
        this.E = j3;
        this.f295417m = LayoutInflater.from(activity2);
        this.C = pinnedHeaderIphoneTreeView;
        this.f295415h = handler;
        this.D = TroopFileTransferManager.O(qQAppInterface, j3);
        this.f295412d = activity.getResources().getDimensionPixelSize(R.dimen.aa6);
        this.H = new ArrayList();
        this.I = new ArrayList();
    }

    public static String f(TextView textView, int i3, String str, String str2) {
        int width = textView.getWidth();
        TextPaint paint = textView.getPaint();
        float measureText = paint.measureText(str);
        if (measureText < width) {
            return str2;
        }
        float f16 = (i3 * width) - 50;
        if (measureText <= f16) {
            return str2;
        }
        int i16 = 0;
        while (true) {
            int length = (str2.length() - i16) - 1;
            if (length < 1) {
                return str2;
            }
            String str3 = str2.substring(0, length) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            if (paint.measureText(str.replace(str2, str3)) < f16) {
                return str3;
            }
            i16++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SpannableStringBuilder k(String str, String str2, TextView textView, String str3, String str4) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) str).append((CharSequence) "  ");
        spannableStringBuilder.append((CharSequence) str3).append((CharSequence) "  ");
        spannableStringBuilder.append((CharSequence) str4);
        String f16 = f(textView, 1, spannableStringBuilder.toString(), str3);
        QLog.d(L, 4, "cutText:" + f16);
        spannableStringBuilder.clear();
        spannableStringBuilder.append((CharSequence) str).append((CharSequence) "  ");
        if (!TextUtils.isEmpty(str2)) {
            spannableStringBuilder.append(com.tencent.mobileqq.search.util.a.b(textView, f16, str2, true)).append((CharSequence) "  ");
        } else {
            spannableStringBuilder.append((CharSequence) f16).append((CharSequence) "  ");
        }
        spannableStringBuilder.append((CharSequence) str4);
        return spannableStringBuilder;
    }

    private void o(TextView textView, String str, String str2) {
        if (str == null) {
            str = "";
        }
        textView.setTag(R.id.f30600os, str);
        if (str2 == null) {
            str2 = "";
        }
        textView.setTag(R.id.f30590or, str2);
    }

    public void d(List<o> list, String str) {
        this.F = str;
        int i3 = 0;
        if (list != null && list.size() != 0) {
            int size = list.size();
            for (int i16 = 0; i16 < size; i16++) {
                o oVar = list.get(i16);
                if (oVar.f295504a == this.E) {
                    this.H.add(oVar);
                } else {
                    this.I.add(oVar);
                }
            }
            this.f295415h.sendEmptyMessage(4);
        } else {
            e();
            this.f295415h.sendEmptyMessage(3);
        }
        if (TroopUtils.r(this.H) && TroopUtils.r(this.I)) {
            i3 = 3;
        } else if (TroopUtils.r(this.H)) {
            i3 = 2;
        } else if (!TroopUtils.r(this.I)) {
            i3 = 1;
        }
        ReportController.o(this.f295414f, "P_CliOper", "Grp_files", "", "search", "exp_result", 0, 0, String.valueOf(this.E), AppSetting.d(), String.valueOf(i3), "");
    }

    public void e() {
        List<o> list = this.H;
        if (list != null) {
            list.clear();
        }
        List<o> list2 = this.I;
        if (list2 != null) {
            list2.clear();
        }
    }

    public o g(String str) {
        com.tencent.mobileqq.troop.data.n nVar;
        com.tencent.mobileqq.troop.data.n nVar2;
        if (this.H != null) {
            for (int i3 = 0; i3 < this.H.size(); i3++) {
                o oVar = this.H.get(i3);
                if (oVar != null && (nVar2 = oVar.f295512i) != null && nVar2.f294916b.equals(str)) {
                    return oVar;
                }
            }
        }
        if (this.I == null) {
            return null;
        }
        for (int i16 = 0; i16 < this.I.size(); i16++) {
            o oVar2 = this.I.get(i16);
            if (oVar2 != null && (nVar = oVar2.f295512i) != null && nVar.f294916b.equals(str)) {
                return oVar2;
            }
        }
        return null;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i3, int i16) {
        return i16;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i3) {
        return Integer.valueOf(i3);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        if (TroopUtils.r(this.H) && TroopUtils.r(this.I)) {
            return 0;
        }
        return TroopUtils.r(this.I) ? 1 : 2;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i3) {
        return i3;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1 && this.K) {
            this.J = false;
            RollangleImageView.setSuspendLoad(false);
            i();
        }
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    public void i() {
        int lastVisiblePosition = this.C.getLastVisiblePosition();
        for (int firstVisiblePosition = this.C.getFirstVisiblePosition(); firstVisiblePosition <= lastVisiblePosition; firstVisiblePosition++) {
            long expandableListPosition = this.C.getExpandableListPosition(firstVisiblePosition);
            if (ExpandableListView.getPackedPositionType(expandableListPosition) == 1) {
                int packedPositionGroup = ExpandableListView.getPackedPositionGroup(expandableListPosition);
                int packedPositionChild = ExpandableListView.getPackedPositionChild(expandableListPosition);
                if (packedPositionGroup >= 0 && packedPositionGroup < getGroupCount() && (getChild(packedPositionGroup, packedPositionChild) instanceof o)) {
                    o oVar = (o) getChild(packedPositionGroup, packedPositionChild);
                    ViewHolder viewHolder = this.G.get(oVar);
                    if (oVar != null) {
                        l(this.f295414f, viewHolder.f295424c, oVar.f295504a, oVar.f295512i);
                    }
                }
            }
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i3, int i16) {
        return true;
    }

    public void j() {
        List<o> list = this.H;
        if (list != null) {
            list.clear();
            this.H = null;
        }
        List<o> list2 = this.I;
        if (list2 != null) {
            list2.clear();
            this.I = null;
        }
        HashMap<o, ViewHolder> hashMap = this.G;
        if (hashMap != null) {
            hashMap.clear();
            this.G = null;
        }
    }

    public void l(QQAppInterface qQAppInterface, AsyncImageView asyncImageView, long j3, com.tencent.mobileqq.troop.data.n nVar) {
        if (FileUtils.fileExistsAndNotEmpty(nVar.f294937w)) {
            FileManagerUtil.setFileIcon(asyncImageView, nVar.f294937w, FileManagerUtil.getFileType(nVar.f294917c));
        } else {
            asyncImageView.setDefaultImage(FileManagerUtil.getFileIconResId(nVar.f294917c));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z16, com.tencent.mobileqq.troop.data.n nVar, AsyncImageView asyncImageView, o oVar) {
        if (z16) {
            return;
        }
        if (FileUtils.fileExistsAndNotEmpty(nVar.f294937w)) {
            FileManagerUtil.setFileIcon(asyncImageView, nVar.f294937w, FileManagerUtil.getFileType(nVar.f294917c));
        } else {
            asyncImageView.setDefaultImage(FileManagerUtil.getFileIconResId(nVar.f294917c));
            TroopFileTransferManager.O(this.f295414f, oVar.f295504a).C(nVar.f294916b, nVar.f294917c, nVar.f294919e, 128, null);
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i3) {
        if (i3 == 0) {
            if (!TroopUtils.r(this.H)) {
                return this.H.size();
            }
        } else if (!TroopUtils.r(this.I)) {
            return this.I.size();
        }
        return 1;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i3, boolean z16, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f295417m.inflate(R.layout.a1q, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(R.id.group_name);
        if (i3 == 0) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(R.string.elb);
        }
        view.setFocusable(true);
        this.C.expandGroup(i3);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public View f295422a;

        /* renamed from: b, reason: collision with root package name */
        public ChildPressEffectRelativeLayout f295423b;

        /* renamed from: c, reason: collision with root package name */
        public AsyncImageView f295424c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f295425d;

        /* renamed from: e, reason: collision with root package name */
        public TextView f295426e;

        /* renamed from: f, reason: collision with root package name */
        public TextView f295427f;

        public ViewHolder(View view, View.OnClickListener onClickListener) {
            ChildPressEffectRelativeLayout childPressEffectRelativeLayout = (ChildPressEffectRelativeLayout) view.findViewById(R.id.f167025k20);
            this.f295423b = childPressEffectRelativeLayout;
            childPressEffectRelativeLayout.setOnClickListener(onClickListener);
            this.f295422a = view;
            this.f295424c = (AsyncImageView) view.findViewById(R.id.f167030k25);
            TextView textView = (TextView) view.findViewById(R.id.k26);
            this.f295425d = textView;
            textView.setMaxLines(2);
            this.f295426e = (TextView) view.findViewById(R.id.f167028k23);
            TextView textView2 = (TextView) view.findViewById(R.id.k2b);
            this.f295427f = textView2;
            textView2.setOnClickListener(onClickListener);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(String str, String str2, String str3) {
            this.f295422a.setContentDescription(this.f295425d.getText() + "," + str3 + ",\u6765\u81ea," + str2 + "," + str);
            if (QLog.isColorLevel() && TextUtils.isEmpty(this.f295425d.getText())) {
                QLog.i(TroopFileSearchExpandableListAdapter.L, 1, "updateConvertViewDescription, fileName is empty!");
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:68:0x0145, code lost:
        
            if (r6.toLowerCase().contains(r3.toLowerCase()) != false) goto L52;
         */
        /* JADX WARN: Removed duplicated region for block: B:16:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x014d  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x011c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(Context context, o oVar, int i3, boolean z16) {
            boolean z17;
            long j3;
            String str;
            String str2;
            ArrayList<String> arrayList;
            String str3;
            int e16;
            String str4;
            if (!TextUtils.isEmpty(oVar.f295505b)) {
                this.f295427f.setText(oVar.f295505b);
                this.f295427f.setVisibility(0);
            } else {
                this.f295427f.setVisibility(8);
            }
            if (i3 == 0) {
                this.f295427f.setVisibility(8);
            } else {
                this.f295427f.setTag(R.id.giu, oVar);
            }
            this.f295423b.setTag(R.id.giu, oVar);
            this.f295423b.setTag(R.id.giv, Integer.valueOf(i3));
            com.tencent.mobileqq.troop.data.n nVar = oVar.f295512i;
            ComponentCallbacks2 componentCallbacks2 = TroopFileSearchExpandableListAdapter.this.f295413e;
            TroopMemberInfo troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(String.valueOf(oVar.f295504a), String.valueOf(oVar.f295506c), componentCallbacks2 instanceof LifecycleOwner ? (LifecycleOwner) componentCallbacks2 : null, TroopFileSearchExpandableListAdapter.L);
            String str5 = "";
            if (troopMemberInfoSync != null) {
                if (ac.v0(troopMemberInfoSync.troopnick, oVar.f295509f + "")) {
                    z17 = true;
                    final String str6 = z17 ? troopMemberInfoSync.troopnick : null;
                    j3 = oVar.f295509f;
                    if (j3 <= 0) {
                        String valueOf = String.valueOf(j3);
                        TroopFileSearchManager g16 = TroopFileSearchManager.g();
                        com.tencent.mobileqq.search.c d16 = g16.d(valueOf);
                        if (d16 != null) {
                            e16 = TroopFileSearchManager.e(TroopFileSearchExpandableListAdapter.this.F, str6, oVar.f295510g, d16.f283094j0, d16.f283095k0, oVar.f295511h, d16.f283092h0, d16.f283093i0);
                            str6 = TroopFileSearchManager.h(str6, oVar.f295510g, oVar.f295511h, e16);
                        } else {
                            e16 = TroopFileSearchManager.e(TroopFileSearchExpandableListAdapter.this.F, str6, oVar.f295510g, null, null, oVar.f295511h, null, null);
                            str6 = TroopFileSearchManager.h(str6, oVar.f295510g, oVar.f295511h, e16);
                        }
                        if (TextUtils.isEmpty(str6)) {
                            if (TextUtils.isEmpty(oVar.f295510g)) {
                                str4 = oVar.f295511h;
                            } else {
                                str4 = oVar.f295510g;
                            }
                            str6 = str4;
                        } else if (e16 == 1 || e16 == 4 || e16 == 7) {
                            str2 = TroopFileSearchExpandableListAdapter.this.F;
                        } else if (e16 == 5 || e16 == 6 || e16 == 2 || e16 == 3) {
                            str2 = g16.f(TroopFileSearchExpandableListAdapter.this.F, valueOf);
                        }
                        str2 = "";
                    } else {
                        if (!z17) {
                            str6 = oVar.f295507d;
                        }
                        ArrayList<String> arrayList2 = oVar.f295508e;
                        if (arrayList2 != null && arrayList2.size() > 0) {
                            str2 = oVar.f295508e.get(0);
                            if (!TextUtils.isEmpty(str6)) {
                            }
                        }
                        str = "";
                        arrayList = oVar.f295508e;
                        if (arrayList != null && arrayList.size() > 0) {
                            str3 = oVar.f295508e.get(0);
                            if (!TextUtils.isEmpty(nVar.f294917c) && nVar.f294917c.toLowerCase().contains(str3.toLowerCase())) {
                                str5 = str3;
                            }
                        }
                        final String e17 = nVar.e();
                        final String str7 = nVar.E;
                        TroopFileSearchExpandableListAdapter.this.n(this.f295425d, nVar, str5, new Runnable() { // from class: com.tencent.mobileqq.troop.file.data.TroopFileSearchExpandableListAdapter.ViewHolder.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ViewHolder.this.c(str7, str6, e17);
                            }
                        });
                        TroopFileSearchExpandableListAdapter.this.m(z16, nVar, this.f295424c, oVar);
                        this.f295426e.setText(TroopFileSearchExpandableListAdapter.this.k(str7, str, this.f295426e, str6, e17));
                        c(str7, str6, e17);
                    }
                    str = str2;
                    arrayList = oVar.f295508e;
                    if (arrayList != null) {
                        str3 = oVar.f295508e.get(0);
                        if (!TextUtils.isEmpty(nVar.f294917c)) {
                            str5 = str3;
                        }
                    }
                    final String e172 = nVar.e();
                    final String str72 = nVar.E;
                    TroopFileSearchExpandableListAdapter.this.n(this.f295425d, nVar, str5, new Runnable() { // from class: com.tencent.mobileqq.troop.file.data.TroopFileSearchExpandableListAdapter.ViewHolder.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewHolder.this.c(str72, str6, e172);
                        }
                    });
                    TroopFileSearchExpandableListAdapter.this.m(z16, nVar, this.f295424c, oVar);
                    this.f295426e.setText(TroopFileSearchExpandableListAdapter.this.k(str72, str, this.f295426e, str6, e172));
                    c(str72, str6, e172);
                }
            }
            z17 = false;
            if (z17) {
            }
            j3 = oVar.f295509f;
            if (j3 <= 0) {
            }
            str = str2;
            arrayList = oVar.f295508e;
            if (arrayList != null) {
            }
            final String e1722 = nVar.e();
            final String str722 = nVar.E;
            TroopFileSearchExpandableListAdapter.this.n(this.f295425d, nVar, str5, new Runnable() { // from class: com.tencent.mobileqq.troop.file.data.TroopFileSearchExpandableListAdapter.ViewHolder.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewHolder.this.c(str722, str6, e1722);
                }
            });
            TroopFileSearchExpandableListAdapter.this.m(z16, nVar, this.f295424c, oVar);
            this.f295426e.setText(TroopFileSearchExpandableListAdapter.this.k(str722, str, this.f295426e, str6, e1722));
            c(str722, str6, e1722);
        }
    }

    private boolean h(TextView textView, String str, String str2) {
        String str3 = (String) textView.getTag(R.id.f30600os);
        return (!TextUtils.isEmpty(str3) && TextUtils.equals(str3, str) && TextUtils.equals((String) textView.getTag(R.id.f30590or), str2)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final TextView textView, final com.tencent.mobileqq.troop.data.n nVar, final String str, final Runnable runnable) {
        if (textView != null && h(textView, nVar.f294917c, str)) {
            o(textView, nVar.f294917c, str);
            textView.setMaxLines(1);
            if (TextUtils.isEmpty(str)) {
                textView.setText(nVar.f294917c);
            } else {
                if (textView.getWidth() > 0) {
                    CharSequence b16 = com.tencent.mobileqq.search.util.a.b(textView, nVar.f294917c, str, true);
                    textView.setText("");
                    textView.setText(b16);
                    return;
                }
                textView.post(new Runnable() { // from class: com.tencent.mobileqq.troop.file.data.TroopFileSearchExpandableListAdapter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CharSequence b17 = com.tencent.mobileqq.search.util.a.b(textView, nVar.f294917c, str, true);
                        textView.setText("");
                        textView.setText(b17);
                        runnable.run();
                    }
                });
            }
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i3, int i16) {
        if (i3 < 0 || i3 >= getGroupCount()) {
            return null;
        }
        if (i3 == 0) {
            if (i16 < 0 || i16 >= getChildrenCount(0)) {
                return null;
            }
            return this.H.get(i16);
        }
        if (i3 != 1 || i16 < 0 || i16 >= getChildrenCount(1)) {
            return null;
        }
        return this.I.get(i16);
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        if (i3 == 0) {
            this.K = true;
            this.f295416i.sendEmptyMessageDelayed(1, 1000L);
            i();
        } else {
            this.K = false;
            RollangleImageView.setSuspendLoad(true);
            this.J = true;
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (i3 == 0 && TroopUtils.r(this.H)) {
            View inflate = LayoutInflater.from(this.f295413e).inflate(R.layout.a1s, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.k7o)).setText(this.f295413e.getString(R.string.ela, this.F));
            return inflate;
        }
        o oVar = (o) getChild(i3, i16);
        if (oVar == null) {
            return null;
        }
        if (view == null) {
            view = this.f295417m.inflate(R.layout.a1t, viewGroup, false);
            viewHolder = new ViewHolder(view, this);
            view.setTag(viewHolder);
        } else {
            Object tag = view.getTag();
            if (tag instanceof ViewHolder) {
                viewHolder = (ViewHolder) tag;
            } else {
                view = this.f295417m.inflate(R.layout.a1t, viewGroup, false);
                viewHolder = new ViewHolder(view, this);
                view.setTag(viewHolder);
            }
        }
        this.G.put(oVar, viewHolder);
        viewHolder.b(this.f295413e, oVar, i3, this.J);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(String.valueOf(this.E));
        int id5 = view.getId();
        if (id5 != R.id.f167025k20) {
            if (id5 != R.id.k2b) {
                return;
            }
            Object tag = view.getTag(R.id.giu);
            if (tag instanceof o) {
                o oVar = (o) tag;
                TroopManager troopManager = (TroopManager) this.f295414f.getManager(QQManagerFactory.TROOP_MANAGER);
                String valueOf = String.valueOf(oVar.f295504a);
                String q16 = troopManager.q(valueOf);
                if (troopInfoFromCache != null) {
                    TroopUtils.I(this.f295413e, aq.a(29, valueOf, q16, oVar.f295505b, troopInfoFromCache.troopowneruin, troopInfoFromCache.Administrator, (byte) troopInfoFromCache.cGroupOption, troopInfoFromCache.dwGroupClassExt, troopInfoFromCache.troopface, troopInfoFromCache.fingertroopmemo, troopInfoFromCache.location, troopInfoFromCache.grade, troopInfoFromCache.school, troopInfoFromCache.strLocation, true, null, troopInfoFromCache.dwGroupFlagExt, troopInfoFromCache.dwAuthGroupType, 0), 2);
                    ReportController.o(this.f295414f, "P_CliOper", "Grp_files", "", "search", "Clk_grpname", 0, 0, String.valueOf(this.E), AppSetting.d(), "", "");
                    return;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.i(L, 2, "troopInfo is null");
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (troopInfoFromCache == null || !troopInfoFromCache.hadJoinTroop()) {
            return;
        }
        Object tag2 = view.getTag(R.id.giu);
        if (tag2 instanceof o) {
            o oVar2 = (o) tag2;
            TroopFileTransferManager O = TroopFileTransferManager.O(this.f295414f, oVar2.f295504a);
            com.tencent.mobileqq.troop.data.n nVar = oVar2.f295512i;
            t H = O.H(nVar.f294916b);
            if (H == null) {
                H = TroopFileUtils.k(this.f295414f, oVar2.f295504a, nVar.f294915a.toString(), nVar.f294916b, nVar.f294917c, nVar.f294918d, nVar.f294919e);
                H.f294980n = nVar.f294938x;
                H.f294981o = nVar.f294939y;
                H.f294979m = nVar.f294937w;
            }
            t tVar = H;
            if (tVar.f294976j == 0) {
                tVar.f294976j = nVar.f294918d;
            }
            QFileUtils.n(this.f295414f, this.f295413e, null, null, oVar2.f295504a, tVar, String.valueOf(nVar.f294920f), nVar.f294923i, 2, 4, QFileUtils.b0(view.findViewById(R.id.f167030k25), nVar.f294917c), false, false);
            ReportController.o(this.f295414f, "P_CliOper", "Grp_files", "", "search", "Clk_result", 0, 0, String.valueOf(this.E), AppSetting.d(), String.valueOf(((Integer) view.getTag(R.id.giv)).intValue()), "");
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
    }
}
