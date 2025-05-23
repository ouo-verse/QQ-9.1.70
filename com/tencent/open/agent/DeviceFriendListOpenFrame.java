package com.tencent.open.agent;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import gp3.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DeviceFriendListOpenFrame extends OpenFrame implements IndexView.b, AdapterView.OnItemClickListener, PinnedDividerListView.b, View.OnTouchListener, e.b {
    protected static final String K = "com.tencent.open.agent.DeviceFriendListOpenFrame";
    protected PinnedDividerListView E;
    protected b F;
    protected IndexView G;
    protected EditText H;
    protected RelativeLayout I;
    protected Handler J;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        DeviceFriendListOpenFrame.this.F.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                DeviceFriendListOpenFrame.this.I.setPadding(0, 0, 0, 0);
                return;
            }
            DeviceFriendListOpenFrame.this.I.setPadding(0, 0, 40, 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    protected class b extends PinnedDividerListView.a {

        /* renamed from: d, reason: collision with root package name */
        protected LinkedHashMap<String, List<Friend>> f339783d = new LinkedHashMap<>();

        /* renamed from: e, reason: collision with root package name */
        protected String[] f339784e = new String[0];

        /* renamed from: f, reason: collision with root package name */
        protected int[] f339785f = new int[0];

        public b() {
            b();
        }

        protected void b() {
            char c16;
            int i3;
            String str;
            this.f339783d.clear();
            List<Friend> a16 = DeviceFriendListOpenFrame.this.f339902h.a();
            com.tencent.open.base.f.a(DeviceFriendListOpenFrame.K, "-->start constructHashStruct()");
            Iterator<Friend> it = a16.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                i3 = 0;
                String str2 = "#";
                if (!hasNext) {
                    break;
                }
                Friend next = it.next();
                String str3 = next.E;
                if (str3 == null || str3.length() == 0) {
                    str = "#";
                } else {
                    str = next.E.substring(0, 1);
                }
                char charAt = str.charAt(0);
                if (('A' <= charAt && charAt <= 'Z') || ('a' <= charAt && charAt <= 'z')) {
                    str2 = str.toUpperCase();
                }
                if (this.f339783d.get(str2) == null) {
                    this.f339783d.put(str2, new ArrayList());
                }
                this.f339783d.get(str2).add(next);
            }
            LinkedHashMap<String, List<Friend>> linkedHashMap = this.f339783d;
            this.f339783d = new LinkedHashMap<>();
            for (c16 = EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET; c16 <= 'Z'; c16 = (char) (c16 + 1)) {
                if (linkedHashMap.get(String.valueOf(c16)) != null) {
                    this.f339783d.put(String.valueOf(c16), linkedHashMap.get(String.valueOf(c16)));
                }
            }
            if (linkedHashMap.get("#") != null) {
                this.f339783d.put("#", linkedHashMap.get("#"));
            }
            linkedHashMap.clear();
            int[] iArr = new int[this.f339783d.keySet().size()];
            this.f339785f = iArr;
            this.f339784e = new String[iArr.length];
            Iterator<String> it5 = this.f339783d.keySet().iterator();
            int[] iArr2 = this.f339785f;
            if (iArr2.length == 0) {
                return;
            }
            iArr2[0] = 0;
            int i16 = 1;
            while (true) {
                int[] iArr3 = this.f339785f;
                if (i16 >= iArr3.length) {
                    break;
                }
                iArr3[i16] = iArr3[i16] + iArr3[i16 - 1] + this.f339783d.get(it5.next()).size() + 1;
                i16++;
            }
            Iterator<String> it6 = this.f339783d.keySet().iterator();
            while (it6.hasNext()) {
                this.f339784e[i3] = it6.next();
                i3++;
            }
            com.tencent.open.base.f.a(DeviceFriendListOpenFrame.K, "-->end constructHashStruct()");
        }

        public int c(String str) {
            if (this.f339784e != null) {
                int i3 = 0;
                while (true) {
                    String[] strArr = this.f339784e;
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
                    return this.f339785f[i3];
                }
            }
            return -1;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public void configDividerView(View view, int i3) {
            int binarySearch = Arrays.binarySearch(this.f339785f, i3);
            if (binarySearch < 0) {
                binarySearch = (-(binarySearch + 1)) - 1;
            }
            if (binarySearch >= 0) {
                String[] strArr = this.f339784e;
                if (binarySearch < strArr.length) {
                    ((TextView) view).setText(strArr[binarySearch]);
                }
            }
        }

        public void d() {
            b();
            super.notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int[] iArr = this.f339785f;
            if (iArr.length == 0) {
                return 0;
            }
            return iArr[iArr.length - 1] + this.f339783d.get(this.f339784e[r2.length - 1]).size() + 1;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public int getDividerLayout() {
            return R.layout.f168254qf;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            int binarySearch = Arrays.binarySearch(this.f339785f, i3);
            if (binarySearch >= 0) {
                return null;
            }
            int i16 = (-(binarySearch + 1)) - 1;
            List<Friend> list = this.f339783d.get(this.f339784e[i16]);
            int i17 = (i3 - this.f339785f[i16]) - 1;
            if (i17 < 0 || i17 >= list.size()) {
                return null;
            }
            return list.get(i17);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            c cVar;
            int binarySearch = Arrays.binarySearch(this.f339785f, i3);
            if (view == null) {
                view = DeviceFriendListOpenFrame.this.D.inflate(R.layout.byd, viewGroup, false);
                cVar = new c();
                cVar.I = (RelativeLayout) view.findViewById(R.id.icx);
                cVar.F = (TextView) view.findViewById(R.id.k8u);
                cVar.E = (CheckBox) view.findViewById(R.id.axa);
                cVar.G = (ImageView) view.findViewById(R.id.icon);
                cVar.H = (TextView) view.findViewById(R.id.f5e);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            if (binarySearch < 0) {
                int i16 = (-(binarySearch + 1)) - 1;
                Friend friend = this.f339783d.get(this.f339784e[i16]).get((i3 - this.f339785f[i16]) - 1);
                if (DeviceFriendListOpenFrame.this.f339902h.n(friend.f340346d)) {
                    cVar.E.setChecked(true);
                } else {
                    cVar.E.setChecked(false);
                }
                ArrayList<String> arrayList = DeviceFriendListOpenFrame.this.f339903i.f339812z0;
                if (arrayList != null && arrayList.contains(friend.f340346d)) {
                    cVar.E.setEnabled(false);
                } else {
                    cVar.E.setEnabled(true);
                }
                String str = friend.f340349h;
                if (str == null || "".equals(str)) {
                    friend.f340349h = gp3.f.a(DeviceFriendListOpenFrame.this.f339903i.F2(), friend.f340346d);
                }
                cVar.J = friend.f340349h;
                cVar.I.setVisibility(0);
                cVar.F.setVisibility(8);
                Bitmap b16 = gp3.e.a().b(friend.f340349h);
                if (b16 == null) {
                    cVar.G.setImageResource(R.drawable.f160830com);
                    gp3.e.a().c(friend.f340349h, DeviceFriendListOpenFrame.this);
                } else {
                    cVar.G.setImageBitmap(b16);
                }
                String str2 = friend.f340348f;
                if (str2 != null && !"".equals(str2)) {
                    cVar.H.setText(friend.f340348f);
                } else {
                    cVar.H.setText(friend.f340347e);
                }
            } else {
                cVar.I.setVisibility(8);
                cVar.F.setVisibility(0);
                cVar.F.setText(String.valueOf(this.f339784e[binarySearch]));
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public boolean isDividerView(int i3) {
            if (Arrays.binarySearch(this.f339785f, i3) >= 0) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class c extends com.tencent.mobileqq.troop.memberlist.b {
        public CheckBox E;
        public TextView F;
        public ImageView G;
        public TextView H;
        public RelativeLayout I;
        public String J;
    }

    public DeviceFriendListOpenFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.J = new a();
    }

    @Override // com.tencent.open.agent.OpenFrame, com.tencent.common.app.InnerFrame
    public void j(Bundle bundle) {
        super.j(bundle);
        super.setContentView(R.layout.f169084by4);
        p();
    }

    @Override // com.tencent.common.app.InnerFrame
    public void m(Bundle bundle) {
        com.tencent.open.base.f.a(K, "-->onStart()");
        super.m(bundle);
        this.E.setSelection(0);
        FriendChooser friendChooser = this.f339903i;
        friendChooser.M2(true, true, friendChooser.getString(R.string.a6a), this.f339903i.getString(R.string.asd), this.f339903i.getString(R.string.f170647xd));
        if (this.F == null) {
            b bVar = new b();
            this.F = bVar;
            this.E.setAdapter((ListAdapter) bVar);
        }
        this.F.d();
    }

    @Override // com.tencent.open.agent.OpenFrame
    public void o() {
        this.F.d();
    }

    @Override // gp3.e.b
    public void onImageLoaded(final String str, final Bitmap bitmap, String str2) {
        com.tencent.open.base.f.a(K, "-->onImageLoaded() url = " + str);
        this.J.post(new Runnable() { // from class: com.tencent.open.agent.DeviceFriendListOpenFrame.2
            @Override // java.lang.Runnable
            public void run() {
                int childCount = DeviceFriendListOpenFrame.this.E.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    c cVar = (c) DeviceFriendListOpenFrame.this.E.getChildAt(i3).getTag();
                    if (cVar != null && str.equals(cVar.J)) {
                        cVar.G.setImageBitmap(bitmap);
                        return;
                    }
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.widget.IndexView.b
    public void onIndexChanged(String str) {
        if ("$".equals(str)) {
            this.E.setSelection(0);
            return;
        }
        int c16 = this.F.c(str);
        if (c16 != -1) {
            PinnedDividerListView pinnedDividerListView = this.E;
            pinnedDividerListView.setSelection(c16 + pinnedDividerListView.getHeaderViewsCount());
        }
    }

    @Override // com.tencent.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        int headerViewsCount;
        Friend friend;
        c cVar = (c) view.getTag();
        if (cVar != null && cVar.E != null && (headerViewsCount = i3 - this.E.getHeaderViewsCount()) >= 0 && (friend = (Friend) this.F.getItem(headerViewsCount)) != null) {
            ArrayList<String> arrayList = this.f339903i.f339812z0;
            if (arrayList != null && arrayList.contains(friend.f340346d)) {
                return;
            }
            this.f339903i.J2(friend);
            if (this.f339902h.n(friend.f340346d)) {
                cVar.E.setChecked(true);
            } else {
                cVar.E.setChecked(false);
            }
        }
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.b
    public void onLayout(View view, int i3, int i16, int i17, int i18) {
        if ((this.E.getFirstVisiblePosition() > 0 || (this.E.getFirstVisiblePosition() == 0 && this.E.getChildCount() < this.F.getCount() + this.E.getHeaderViewsCount())) && !this.f339903i.E0) {
            this.G.setVisibility(0);
            this.J.sendEmptyMessage(1);
        } else {
            this.G.setVisibility(4);
            this.J.sendEmptyMessage(2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f339903i.I2();
        }
        return true;
    }

    protected void p() {
        this.E = (PinnedDividerListView) super.findViewById(R.id.atu);
        IndexView indexView = (IndexView) super.findViewById(R.id.djh);
        this.G = indexView;
        indexView.setIndex(new String[]{"$", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "T", "U", "V", "W", "X", "Y", "Z", "#"});
        this.G.setOnIndexChangedListener(this);
        this.E.setSelector(R.color.ajr);
        this.E.setOnItemClickListener(this);
        this.E.setOnLayoutListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) this.f339903i.getLayoutInflater().inflate(R.layout.search_box, (ViewGroup) this.E, false);
        this.I = relativeLayout;
        EditText editText = (EditText) relativeLayout.findViewById(R.id.et_search_keyword);
        this.H = editText;
        editText.setOnTouchListener(this);
        ((Button) this.I.findViewById(R.id.btn_cancel_search)).setVisibility(8);
        this.E.addHeaderView(this.I);
    }
}
