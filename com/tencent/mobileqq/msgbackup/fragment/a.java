package com.tencent.mobileqq.msgbackup.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.msgbackup.data.j;
import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a extends RecyclerView.Adapter<ViewOnClickListenerC8111a> implements DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_;
    private BaseQQAppInterface C;
    private RecyclerView D;
    private b E;

    /* renamed from: d, reason: collision with root package name */
    private final LayoutInflater f251258d;

    /* renamed from: e, reason: collision with root package name */
    private SparseArray<Boolean> f251259e;

    /* renamed from: f, reason: collision with root package name */
    private List<j> f251260f;

    /* renamed from: h, reason: collision with root package name */
    private long f251261h;

    /* renamed from: i, reason: collision with root package name */
    private Hashtable<String, Bitmap> f251262i;

    /* renamed from: m, reason: collision with root package name */
    private Context f251263m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msgbackup.fragment.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class ViewOnClickListenerC8111a extends RecyclerView.ViewHolder implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public View f251264d;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f251265e;

        /* renamed from: f, reason: collision with root package name */
        public SingleLineTextView f251266f;

        /* renamed from: h, reason: collision with root package name */
        private CheckBox f251267h;

        /* renamed from: i, reason: collision with root package name */
        private b f251268i;

        public ViewOnClickListenerC8111a(View view, b bVar) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, view, bVar);
                return;
            }
            this.f251264d = view;
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.lmx);
            this.f251267h = checkBox;
            checkBox.setButtonDrawable(R.drawable.h_);
            this.f251267h.setOnCheckedChangeListener(null);
            this.f251267h.setOnCheckedChangeListener(this);
            this.f251265e = (ImageView) view.findViewById(R.id.f165861dq1);
            SingleLineTextView singleLineTextView = (SingleLineTextView) view.findViewById(R.id.dr7);
            this.f251266f = singleLineTextView;
            singleLineTextView.setTextColor(view.getContext().getResources().getColor(R.color.skin_black_theme_version2));
            this.f251268i = bVar;
            view.setOnClickListener(this);
            view.setTag(this);
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, compoundButton, Boolean.valueOf(z16));
            } else if (this.f251268i != null) {
                int adapterPosition = getAdapterPosition();
                if (QLog.isColorLevel()) {
                    QLog.i("MsgBackup.BackupAndMigrateListAdapter", 2, "BackupAndMigrateItemHolder onCheckedChanged: " + adapterPosition + ", isChecked = " + z16);
                }
                this.f251267h.setChecked(z16);
                a.this.f251259e.setValueAt(adapterPosition, Boolean.valueOf(z16));
                this.f251268i.a(this.f251267h.isChecked(), (j) a.this.f251260f.get(adapterPosition));
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (this.f251268i != null) {
                this.f251267h.setChecked(!this.f251267h.isChecked());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface b {
        void a(boolean z16, j jVar);
    }

    public a(Context context, BaseQQAppInterface baseQQAppInterface, RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, baseQQAppInterface, recyclerView);
            return;
        }
        this.f251261h = 0L;
        this.f251262i = new Hashtable<>();
        this.f251263m = context;
        this.C = baseQQAppInterface;
        this.D = recyclerView;
        this.f251260f = new ArrayList();
        this.f251259e = new SparseArray<>();
        this.f251258d = LayoutInflater.from(context);
    }

    private void r(ViewOnClickListenerC8111a viewOnClickListenerC8111a, int i3, Drawable drawable) {
        j jVar = this.f251260f.get(i3);
        IMsgBackupTempApi iMsgBackupTempApi = (IMsgBackupTempApi) QRoute.api(IMsgBackupTempApi.class);
        String d16 = jVar.d();
        int f16 = jVar.f();
        if (drawable == null) {
            drawable = iMsgBackupTempApi.getFaceDrawable(this.C, this, f16, d16);
        }
        viewOnClickListenerC8111a.f251265e.setImageDrawable(drawable);
        if (jVar.e() != null && !jVar.e().equals("")) {
            viewOnClickListenerC8111a.f251266f.setText(jVar.e());
        } else {
            viewOnClickListenerC8111a.f251266f.setText(jVar.b());
        }
        viewOnClickListenerC8111a.f251267h.setChecked(this.f251259e.valueAt(i3).booleanValue());
        if (AppSetting.f99565y) {
            viewOnClickListenerC8111a.f251264d.setContentDescription(jVar.b());
        }
    }

    private void z(ViewOnClickListenerC8111a viewOnClickListenerC8111a, int i3, Drawable drawable) {
        if (i3 >= 0 && i3 < this.f251260f.size()) {
            j jVar = this.f251260f.get(i3);
            if (viewOnClickListenerC8111a != null && jVar != null) {
                if (drawable == null) {
                    String d16 = jVar.d();
                    drawable = ((IMsgBackupTempApi) QRoute.api(IMsgBackupTempApi.class)).getFaceDrawable(this.C, this, jVar.f(), d16);
                }
                r(viewOnClickListenerC8111a, i3, drawable);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f251260f.size();
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (bitmap == null && i3 > 0) {
            return;
        }
        if (bitmap != null) {
            try {
                this.f251262i.put(i16 + ":" + str, bitmap);
            } catch (OutOfMemoryError e16) {
                System.gc();
                e16.printStackTrace();
                QLog.i("MsgBackup.BackupAndMigrateListAdapter", 1, "onDecodeTaskCompleted error:" + e16.getMessage());
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.f251261h;
        if (j3 > 0 && currentTimeMillis - j3 > 300) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i3 > 0 && !z16) {
            return;
        }
        synchronized (this.f251262i) {
            if (this.f251262i.size() == 0) {
                return;
            }
            if (i3 == 0) {
                this.f251261h = 0L;
            } else {
                this.f251261h = currentTimeMillis;
            }
            int childCount = this.D.getChildCount();
            boolean z17 = false;
            for (int i17 = 0; i17 < childCount; i17++) {
                ViewOnClickListenerC8111a viewOnClickListenerC8111a = (ViewOnClickListenerC8111a) this.D.getChildViewHolder(this.D.getChildAt(i17));
                int adapterPosition = viewOnClickListenerC8111a.getAdapterPosition();
                j jVar = this.f251260f.get(adapterPosition);
                if (jVar != null) {
                    String d16 = jVar.d();
                    int intValue = ((Integer) ((IMsgBackupTempApi) QRoute.api(IMsgBackupTempApi.class)).getHeadIcon(this.C, jVar.f(), d16).first).intValue();
                    if (intValue != Integer.MIN_VALUE) {
                        Bitmap bitmap2 = this.f251262i.get(intValue + ":" + d16);
                        if (bitmap2 != null) {
                            z(viewOnClickListenerC8111a, adapterPosition, new BitmapDrawable(this.f251263m.getResources(), bitmap2));
                            z17 = true;
                        }
                    }
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("MsgBackup.BackupAndMigrateListAdapter", 4, "decodecomplete|faceCache size = " + this.f251262i.size() + ", isNeedUpdateAvatar=" + z17);
            }
            this.f251262i.clear();
        }
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        int size = this.f251260f.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f251259e.put(i3, Boolean.FALSE);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(ViewOnClickListenerC8111a viewOnClickListenerC8111a, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewOnClickListenerC8111a, i3);
        } else {
            r(viewOnClickListenerC8111a, i3, null);
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(viewOnClickListenerC8111a, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public ViewOnClickListenerC8111a onCreateViewHolder(ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ViewOnClickListenerC8111a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
        }
        return new ViewOnClickListenerC8111a(this.f251258d.inflate(R.layout.ce_, viewGroup, false), this.E);
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        int size = this.f251259e.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f251259e.setValueAt(i3, Boolean.TRUE);
        }
        notifyDataSetChanged();
    }

    public void w(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bVar);
        } else {
            this.E = bVar;
        }
    }

    public void x(List<j> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        } else {
            this.f251260f.clear();
            this.f251260f.addAll(list);
        }
    }

    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        int size = this.f251259e.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f251259e.setValueAt(i3, Boolean.FALSE);
        }
        notifyDataSetChanged();
    }
}
