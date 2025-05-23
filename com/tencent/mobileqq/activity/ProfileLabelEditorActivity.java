package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileLabelTypeInfo;
import com.tencent.mobileqq.profile.view.ProfileLabelPanel;
import com.tencent.mobileqq.profilecard.entity.ProfileLabelInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardLabelUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class ProfileLabelEditorActivity extends IphoneTitleBarActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: o0, reason: collision with root package name */
    public static final int[][] f176631o0;

    /* renamed from: a0, reason: collision with root package name */
    public LinearLayout f176632a0;

    /* renamed from: b0, reason: collision with root package name */
    public TextView f176633b0;

    /* renamed from: c0, reason: collision with root package name */
    public GridView f176634c0;

    /* renamed from: d0, reason: collision with root package name */
    public g f176635d0;

    /* renamed from: e0, reason: collision with root package name */
    public ProfileLabelPanel f176636e0;

    /* renamed from: f0, reason: collision with root package name */
    public float f176637f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f176638g0;

    /* renamed from: h0, reason: collision with root package name */
    public Card f176639h0;

    /* renamed from: i0, reason: collision with root package name */
    public Context f176640i0;

    /* renamed from: j0, reason: collision with root package name */
    public ProfileLabelPanel.a f176641j0;

    /* renamed from: k0, reason: collision with root package name */
    public List<ProfileLabelInfo> f176642k0;

    /* renamed from: l0, reason: collision with root package name */
    public List<ProfileLabelTypeInfo> f176643l0;

    /* renamed from: m0, reason: collision with root package name */
    public List<Long> f176644m0;

    /* renamed from: n0, reason: collision with root package name */
    private CardObserver f176645n0;

    /* loaded from: classes9.dex */
    class a extends CardObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileLabelEditorActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onCardLabelUpdate(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (z16) {
                ProfileLabelEditorActivity.this.setResult(-1);
                ProfileLabelEditorActivity.this.showToast(R.string.f173189hw3);
            } else {
                ProfileLabelEditorActivity.this.showToast(R.string.f173187hw1);
            }
            ProfileLabelEditorActivity profileLabelEditorActivity = ProfileLabelEditorActivity.this;
            profileLabelEditorActivity.f176638g0 = false;
            profileLabelEditorActivity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileLabelEditorActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                String stringExtra = ProfileLabelEditorActivity.this.getIntent().getStringExtra("uin");
                if (stringExtra != null && stringExtra.equals(ProfileLabelEditorActivity.this.app.getCurrentAccountUin())) {
                    ProfileLabelEditorActivity.this.T2();
                    ReportController.o(ProfileLabelEditorActivity.this.app, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "4", "", "", "");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class c implements com.tencent.mobileqq.profile.view.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileLabelEditorActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.profile.view.a
        public void a(ProfileLabelInfo profileLabelInfo, ToggleButton toggleButton, Boolean bool) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, profileLabelInfo, toggleButton, bool);
                return;
            }
            if (bool.booleanValue()) {
                ProfileLabelEditorActivity profileLabelEditorActivity = ProfileLabelEditorActivity.this;
                if (!profileLabelEditorActivity.N2(profileLabelInfo.labelId, profileLabelEditorActivity.f176642k0)) {
                    ProfileLabelEditorActivity profileLabelEditorActivity2 = ProfileLabelEditorActivity.this;
                    if (!profileLabelEditorActivity2.P2(profileLabelEditorActivity2.f176642k0)) {
                        ReportController.o(ProfileLabelEditorActivity.this.app, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "1", "", "", "");
                        ProfileLabelEditorActivity.this.f176642k0.add(profileLabelInfo);
                    }
                }
                ProfileLabelEditorActivity profileLabelEditorActivity3 = ProfileLabelEditorActivity.this;
                if (profileLabelEditorActivity3.P2(profileLabelEditorActivity3.f176642k0)) {
                    ProfileLabelEditorActivity.this.showToast(R.string.bwy);
                    return;
                }
                return;
            }
            ProfileLabelEditorActivity profileLabelEditorActivity4 = ProfileLabelEditorActivity.this;
            if (!profileLabelEditorActivity4.N2(profileLabelInfo.labelId, profileLabelEditorActivity4.f176642k0)) {
                return;
            }
            ProfileLabelEditorActivity profileLabelEditorActivity5 = ProfileLabelEditorActivity.this;
            profileLabelEditorActivity5.S2(profileLabelInfo, profileLabelEditorActivity5.f176642k0);
            ProfileLabelEditorActivity.this.f176641j0.g(profileLabelInfo, toggleButton);
            ProfileLabelEditorActivity profileLabelEditorActivity6 = ProfileLabelEditorActivity.this;
            profileLabelEditorActivity6.c3(profileLabelEditorActivity6.f176642k0.size());
            g gVar = ProfileLabelEditorActivity.this.f176635d0;
            if (gVar != null) {
                gVar.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes9.dex */
    class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileLabelEditorActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                ProfileLabelEditorActivity.this.finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileLabelEditorActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ProfileLabelEditorActivity.this.T2();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* loaded from: classes9.dex */
    static class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public TextView f176653a;

        /* renamed from: b, reason: collision with root package name */
        public int f176654b;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class g extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        List<ProfileLabelInfo> f176655d;

        /* renamed from: e, reason: collision with root package name */
        private View.OnClickListener f176656e;

        /* loaded from: classes9.dex */
        class a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f fVar;
                int i3;
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    Object tag = view.getTag();
                    if ((tag instanceof f) && (i3 = (fVar = (f) tag).f176654b) >= 0 && i3 < ProfileLabelEditorActivity.this.f176642k0.size()) {
                        ProfileLabelInfo remove = ProfileLabelEditorActivity.this.f176642k0.remove(fVar.f176654b);
                        ProfileLabelEditorActivity profileLabelEditorActivity = ProfileLabelEditorActivity.this;
                        profileLabelEditorActivity.c3(profileLabelEditorActivity.f176642k0.size());
                        g.this.notifyDataSetChanged();
                        g.this.b(remove);
                        ReportController.o(ProfileLabelEditorActivity.this.app, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "2", "", "", "");
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public g(List<ProfileLabelInfo> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileLabelEditorActivity.this, (Object) list);
            } else {
                this.f176656e = new a();
                this.f176655d = list;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ProfileLabelInfo profileLabelInfo) {
            ProfileLabelInfo profileLabelInfo2 = null;
            for (ProfileLabelInfo profileLabelInfo3 : ProfileLabelEditorActivity.this.f176641j0.e().keySet()) {
                if (profileLabelInfo3.labelId.equals(profileLabelInfo.labelId)) {
                    profileLabelInfo2 = profileLabelInfo3;
                }
            }
            if (profileLabelInfo2 != null && ProfileLabelEditorActivity.this.f176641j0.b(profileLabelInfo2)) {
                ProfileLabelPanel.a aVar = ProfileLabelEditorActivity.this.f176641j0;
                aVar.g(profileLabelInfo2, aVar.d(profileLabelInfo2));
            } else {
                c(profileLabelInfo.labelId);
            }
        }

        private void c(Long l3) {
            ArrayList arrayList = new ArrayList();
            Iterator<ProfileLabelTypeInfo> it = ProfileLabelEditorActivity.this.f176643l0.iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().labels);
            }
            ProfileLabelInfo K2 = ProfileLabelEditorActivity.this.K2(l3, arrayList);
            if (K2 != null) {
                K2.toggleStatus();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f176655d.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return this.f176655d.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            f fVar;
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    view = ProfileLabelEditorActivity.this.getLayoutInflater().inflate(R.layout.c09, (ViewGroup) null);
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) (ProfileLabelEditorActivity.this.f176637f0 * 32.0f)));
                    fVar = new f();
                    fVar.f176653a = (TextView) view.findViewById(R.id.ja6);
                    view.setTag(fVar);
                } else {
                    fVar = (f) view.getTag();
                }
                fVar.f176654b = i3;
                int[][] iArr = ProfileLabelEditorActivity.f176631o0;
                int length = i3 % iArr.length;
                view.setBackgroundResource(iArr[length][0]);
                view.setOnClickListener(this.f176656e);
                fVar.f176653a.setTextColor(iArr[length][1]);
                fVar.f176653a.setText(this.f176655d.get(i3).labelName);
                fVar.f176653a.setContentDescription(this.f176655d.get(i3).labelName);
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67276);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f176631o0 = new int[][]{new int[]{R.drawable.b5m, R.color.ai9}, new int[]{R.drawable.b5p, R.color.ai_}, new int[]{R.drawable.b5s, R.color.aia}};
        }
    }

    public ProfileLabelEditorActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f176642k0 = new ArrayList();
        this.f176643l0 = new ArrayList();
        this.f176644m0 = new ArrayList();
        this.f176645n0 = new a();
    }

    private boolean J2() {
        List<ProfileLabelTypeInfo> list = this.f176643l0;
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    private void L2(List<ProfileLabelInfo> list, List<ProfileLabelTypeInfo> list2) {
        Iterator<ProfileLabelTypeInfo> it = list2.iterator();
        while (it.hasNext()) {
            for (ProfileLabelInfo profileLabelInfo : it.next().labels) {
                profileLabelInfo.labelStatus = ProfileLabelInfo.STATUS_NORMAL;
                if (N2(profileLabelInfo.labelId, list)) {
                    profileLabelInfo.labelStatus = ProfileLabelInfo.STATUS_CHECKED;
                }
            }
        }
        V2(list2);
    }

    private void Q2(String str) throws JSONException {
        if (str != null) {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                ProfileLabelTypeInfo profileLabelTypeInfo = new ProfileLabelTypeInfo();
                profileLabelTypeInfo.typeId = optJSONObject.optString("id");
                profileLabelTypeInfo.typeName = optJSONObject.optString("name");
                profileLabelTypeInfo.typeInfo = optJSONObject.optString("classinfo");
                JSONArray optJSONArray = optJSONObject.optJSONArray("taglist");
                int length2 = optJSONArray.length();
                for (int i16 = 0; i16 < length2; i16++) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i16);
                    ProfileLabelInfo profileLabelInfo = new ProfileLabelInfo();
                    profileLabelInfo.labelId = Long.valueOf(jSONObject.optLong("id"));
                    profileLabelInfo.labelName = jSONObject.optString("name");
                    profileLabelInfo.typeId = profileLabelTypeInfo.typeId;
                    profileLabelTypeInfo.labels.add(profileLabelInfo);
                }
                this.f176643l0.add(profileLabelTypeInfo);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String R2(String str) {
        Throwable th5;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inputStream = this.f176640i0.getAssets().open(str);
        } catch (IOException e16) {
            e = e16;
            inputStream = null;
        } catch (Throwable th6) {
            th5 = th6;
            inputStream = null;
            if (inputStream != null) {
            }
            byteArrayOutputStream.close();
            throw th5;
        }
        try {
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr, 0, 4096);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                String str2 = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                try {
                    inputStream.close();
                    byteArrayOutputStream.close();
                } catch (Exception e17) {
                    QLog.e("ProfileLabelEditorActivity", 1, "readDataFromJsonFile error", e17);
                }
                return str2;
            } catch (Throwable th7) {
                th5 = th7;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e18) {
                        QLog.e("ProfileLabelEditorActivity", 1, "readDataFromJsonFile error", e18);
                        throw th5;
                    }
                }
                byteArrayOutputStream.close();
                throw th5;
            }
        } catch (IOException e19) {
            e = e19;
            QLog.e("ProfileLabelEditorActivity", 1, "readDataFromJsonFile error", e);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e26) {
                    QLog.e("ProfileLabelEditorActivity", 1, "readDataFromJsonFile error", e26);
                    return null;
                }
            }
            byteArrayOutputStream.close();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T2() {
        if (M2()) {
            if (this.f176638g0) {
                showToast(R.string.f173188hw2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ProfileLabelEditorActivity", 2, "saveEdit save labes num = " + this.f176642k0.size());
            }
            this.f176638g0 = true;
            ((CardHandler) this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).d5(this.f176642k0);
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U2(List<ProfileLabelInfo> list) {
        if (this.f176642k0 != null) {
            g gVar = new g(this.f176642k0);
            this.f176635d0 = gVar;
            this.f176634c0.setAdapter((ListAdapter) gVar);
            c3(this.f176642k0.size());
        }
        File file = new File(BaseApplicationImpl.getApplication().getFilesDir(), "labelList");
        if (!file.exists()) {
            Z2();
            return;
        }
        byte[] fileToBytes = FileUtils.fileToBytes(file);
        if (fileToBytes != null && fileToBytes.length != 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(fileToBytes);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                this.f176643l0 = (List) objectInputStream.readObject();
                objectInputStream.close();
                byteArrayInputStream.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            } catch (ClassNotFoundException e17) {
                e17.printStackTrace();
            }
            if (!J2()) {
                if (QLog.isColorLevel()) {
                    QLog.d("ProfileLabelEditorActivity", 2, "get available label list fail ");
                }
                Z2();
            }
            if (J2()) {
                L2(list, this.f176643l0);
            }
        }
    }

    private void V2(List<ProfileLabelTypeInfo> list) {
        this.f176636e0 = new ProfileLabelPanel(this.f176640i0, this.f176641j0, list, new c());
        this.f176632a0.addView(this.f176636e0, new LinearLayout.LayoutParams(-1, (int) (this.f176637f0 * 202.0f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<ProfileLabelInfo> W2(String str) {
        Card r16 = ((FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(str);
        this.f176639h0 = r16;
        if (r16 != null) {
            List<ProfileLabelInfo> labelList = r16.getLabelList();
            this.f176642k0 = labelList;
            if (labelList != null) {
                b3(labelList);
            }
        }
        return this.f176642k0;
    }

    private void Y2() {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.ProfileLabelEditorActivity.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileLabelEditorActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                ProfileLabelEditorActivity profileLabelEditorActivity = ProfileLabelEditorActivity.this;
                ThreadManager.getUIHandler().post(new Runnable(profileLabelEditorActivity.W2(profileLabelEditorActivity.app.getCurrentAccountUin())) { // from class: com.tencent.mobileqq.activity.ProfileLabelEditorActivity.3.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ List f176646d;

                    {
                        this.f176646d = r5;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, (Object) r5);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            ProfileLabelEditorActivity.this.U2(this.f176646d);
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                });
            }
        }, 8, null, true);
    }

    private void Z2() {
        try {
            Q2(R2("qvip_default_tags.json"));
        } catch (JSONException e16) {
            e16.printStackTrace();
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    private void b3(List<ProfileLabelInfo> list) {
        this.f176644m0.clear();
        Iterator<ProfileLabelInfo> it = list.iterator();
        while (it.hasNext()) {
            this.f176644m0.add(it.next().labelId);
        }
    }

    ProfileLabelInfo K2(Long l3, List<ProfileLabelInfo> list) {
        ProfileLabelInfo profileLabelInfo = null;
        if (list != null) {
            for (ProfileLabelInfo profileLabelInfo2 : list) {
                if (profileLabelInfo2.labelId.equals(l3)) {
                    profileLabelInfo = profileLabelInfo2;
                }
            }
        }
        return profileLabelInfo;
    }

    boolean M2() {
        List<ProfileLabelInfo> list = this.f176642k0;
        if (list != null && this.f176644m0 != null && list.size() == this.f176644m0.size()) {
            ArrayList arrayList = new ArrayList();
            Iterator<ProfileLabelInfo> it = this.f176642k0.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().labelId);
            }
            if (arrayList.containsAll(this.f176644m0) && this.f176644m0.containsAll(arrayList)) {
                return false;
            }
        }
        return true;
    }

    boolean N2(Long l3, List<ProfileLabelInfo> list) {
        if (K2(l3, list) != null) {
            return true;
        }
        return false;
    }

    boolean P2(List<ProfileLabelInfo> list) {
        if (list.size() >= 7) {
            return true;
        }
        return false;
    }

    void S2(ProfileLabelInfo profileLabelInfo, List<ProfileLabelInfo> list) {
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3).labelId.equals(profileLabelInfo.labelId)) {
                    list.remove(i3);
                    ReportController.o(this.app, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "2", "", "", "");
                }
            }
        }
    }

    void c3(int i3) {
        if (i3 > 7) {
            return;
        }
        this.f176633b0.setText(getString(R.string.hvy) + " (" + i3 + "/7)");
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
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
        super.doOnCreate(bundle);
        if (VasToggle.FEATURE_BATCH_UPDATE.isEnable(true)) {
            ProfileCardLabelUtil.a(getAppInterface());
        }
        addObserver(this.f176645n0);
        this.f176640i0 = this;
        this.f176637f0 = getResources().getDisplayMetrics().density;
        this.f176641j0 = new ProfileLabelPanel.a();
        getResources();
        initUI();
        Y2();
        ReportController.o(this.app, "CliOper", "", "", "card_mall", "0X80066C8", 0, 0, "", "", "", "");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnDestroy();
        this.app.removeObserver(this.f176645n0);
        this.f176641j0.c();
        this.f176641j0 = null;
    }

    public void initUI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.setContentView(R.layout.f168393us);
        getWindow().setBackgroundDrawable(null);
        super.setTitle(getString(R.string.hvz));
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.root);
        this.f176632a0 = linearLayout;
        this.f176633b0 = (TextView) linearLayout.findViewById(R.id.ja7);
        this.f176634c0 = (GridView) this.f176632a0.findViewById(R.id.f166943ja4);
        setRightButton(R.string.h3s, new b());
        enableRightHighlight(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (M2()) {
            DialogUtil.createCustomDialog(this, 230).setMessage(getString(R.string.hvx)).setPositiveButton(R.string.ihc, new e()).setNegativeButton(R.string.f171142no, new d()).show();
            return true;
        }
        finish();
        return false;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    void showToast(int i3) {
        QQToast.makeText(this.f176640i0, i3, 1).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }
}
