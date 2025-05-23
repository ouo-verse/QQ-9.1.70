package com.tencent.mobileqq.teamworkforgroup;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.rely.SingleLineHotwordTextView;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamworkforgroup.b;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class j extends com.tencent.mobileqq.teamworkforgroup.a {

    /* renamed from: m, reason: collision with root package name */
    private Context f292616m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private class a extends b.a {

        /* renamed from: c, reason: collision with root package name */
        ImageView f292617c;

        /* renamed from: d, reason: collision with root package name */
        SingleLineHotwordTextView f292618d;

        /* renamed from: e, reason: collision with root package name */
        TextView f292619e;

        /* renamed from: f, reason: collision with root package name */
        TextView f292620f;

        /* renamed from: g, reason: collision with root package name */
        TextView f292621g;

        /* renamed from: h, reason: collision with root package name */
        View f292622h;

        a() {
            super();
        }
    }

    public j(AppInterface appInterface, Context context, BaseAdapter baseAdapter, int i3) {
        super(appInterface, context, baseAdapter, i3);
        this.f292616m = context;
    }

    private String j(String str, String str2) {
        String str3;
        if (this.f292578a.getCurrentAccountUin().equals(str)) {
            return HardCodeUtil.qqStr(R.string.f230636zo);
        }
        if (this.f292578a instanceof AppInterface) {
            str3 = ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getBuddyName(this.f292578a, str, true);
        } else {
            str3 = null;
        }
        if ((str3 != null && !str3.equals(str)) || TextUtils.isEmpty(str2)) {
            return str3;
        }
        return str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0143  */
    @Override // com.tencent.mobileqq.teamworkforgroup.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View d(int i3, h hVar, View view, ViewGroup viewGroup, boolean z16, boolean z17, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, boolean z18, int i16) {
        a aVar;
        View view2;
        String string;
        long max;
        String str;
        if (view == null) {
            view2 = LayoutInflater.from(this.f292579b).inflate(R.layout.c0h, viewGroup, false);
            aVar = new a();
            aVar.f292617c = (ImageView) view2.findViewById(R.id.azi);
            aVar.f292618d = (SingleLineHotwordTextView) view2.findViewById(R.id.azk);
            aVar.f292621g = (TextView) view2.findViewById(R.id.azl);
            aVar.f292620f = (TextView) view2.findViewById(R.id.f164825b01);
            aVar.f292619e = (TextView) view2.findViewById(R.id.f164826b02);
            aVar.f292622h = view2.findViewById(R.id.azm);
            view2.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
            view2 = view;
        }
        PadInfo padInfo = (PadInfo) hVar;
        int i17 = padInfo.type;
        if (i17 == 1) {
            aVar.f292617c.setImageResource(R.drawable.h3j);
        } else if (i17 == 3) {
            aVar.f292617c.setImageResource(R.drawable.h3k);
        } else {
            aVar.f292617c.setImageResource(R.drawable.h3m);
        }
        boolean z19 = padInfo instanceof GPadInfo;
        if (z19) {
            GPadInfo gPadInfo = (GPadInfo) padInfo;
            if (gPadInfo.searchKeyWordList.size() > 0) {
                aVar.f292618d.setHotwords((ArrayList) gPadInfo.searchKeyWordList);
            }
        }
        aVar.f292618d.setText(padInfo.title);
        int i18 = padInfo.type_list;
        if (i18 != 1) {
            if (!this.f292578a.getCurrentAccountUin().equals("" + padInfo.creatorUin)) {
                if (i18 == 3) {
                    string = String.format(this.f292579b.getResources().getString(R.string.hys), j("" + padInfo.creatorUin, padInfo.shardNick));
                } else {
                    string = String.format(this.f292579b.getResources().getString(R.string.hyq), j("" + padInfo.creatorUin, padInfo.creatorNick));
                }
                aVar.f292621g.setText(string);
                if (!z19) {
                    max = padInfo.lastEditTime;
                } else {
                    max = Math.max(padInfo.lastEditTime, padInfo.currentUserBrowseTime);
                }
                if (max > 0) {
                    if (max == padInfo.lastEditTime) {
                        str = String.format(this.f292579b.getResources().getString(R.string.hyr), j("" + padInfo.lastEditorUin, padInfo.lastEditorNick));
                    } else if (max == 0) {
                        str = String.format(this.f292579b.getResources().getString(R.string.hyp), HardCodeUtil.qqStr(R.string.f230636zo));
                    } else if (max == padInfo.currentUserBrowseTime) {
                        str = String.format(this.f292579b.getResources().getString(R.string.hyt), HardCodeUtil.qqStr(R.string.f230636zo));
                    }
                    if (str != null) {
                        aVar.f292622h.setVisibility(0);
                        aVar.f292620f.setText(str);
                        aVar.f292619e.setText(((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getCloudFileTime(max));
                    } else {
                        aVar.f292622h.setVisibility(8);
                        aVar.f292620f.setText("");
                        aVar.f292619e.setText("");
                    }
                    if (this.f292581d == 1) {
                        if (padInfo.type_list == 4) {
                            if (padInfo.pinInAllList) {
                                view2.setBackgroundResource(R.drawable.f160579kt);
                            } else {
                                view2.setBackgroundResource(R.drawable.f160578ks);
                            }
                        } else if (padInfo.pinedFlag) {
                            view2.setBackgroundResource(R.drawable.f160579kt);
                        } else {
                            view2.setBackgroundResource(R.drawable.f160578ks);
                        }
                    } else {
                        view2.setBackgroundResource(R.drawable.f160578ks);
                    }
                    view2.setOnClickListener(onClickListener);
                    view2.setOnLongClickListener(onLongClickListener);
                    aVar.f292582a = hVar;
                    view2.setTag(-1, Integer.valueOf(i3));
                    return view2;
                }
                str = null;
                if (str != null) {
                }
                if (this.f292581d == 1) {
                }
                view2.setOnClickListener(onClickListener);
                view2.setOnLongClickListener(onLongClickListener);
                aVar.f292582a = hVar;
                view2.setTag(-1, Integer.valueOf(i3));
                return view2;
            }
        }
        string = this.f292579b.getResources().getString(R.string.hxo);
        aVar.f292621g.setText(string);
        if (!z19) {
        }
        if (max > 0) {
        }
        str = null;
        if (str != null) {
        }
        if (this.f292581d == 1) {
        }
        view2.setOnClickListener(onClickListener);
        view2.setOnLongClickListener(onLongClickListener);
        aVar.f292582a = hVar;
        view2.setTag(-1, Integer.valueOf(i3));
        return view2;
    }

    @Override // com.tencent.mobileqq.teamworkforgroup.a
    public List<i> f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.tencent.mobileqq.teamworkforgroup.a.f292564k);
        arrayList.add(com.tencent.mobileqq.teamworkforgroup.a.f292563j);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.teamworkforgroup.a
    public List<i> g(h hVar) {
        boolean z16;
        boolean z17;
        ArrayList arrayList = new ArrayList();
        if (hVar instanceof GPadInfo) {
            GPadInfo gPadInfo = (GPadInfo) hVar;
            if (((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).isInstanceGroupTeamWorkListActivity(this.f292616m)) {
                if (this.f292578a instanceof AppInterface) {
                    z17 = ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).isTroopAdmin(this.f292578a, ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getGroupUin(this.f292616m), this.f292578a.getCurrentAccountUin());
                } else {
                    z17 = false;
                }
                if (gPadInfo.creatorUin == this.f292578a.getLongAccountUin()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            } else {
                z16 = false;
                z17 = false;
            }
            if (z16) {
                BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).getBoolean("TIMDocLimitSettingFlag", false);
            }
            arrayList.add(com.tencent.mobileqq.teamworkforgroup.a.f292564k);
            if (z16 || z17) {
                arrayList.add(com.tencent.mobileqq.teamworkforgroup.a.f292563j);
            }
        }
        return arrayList;
    }
}
