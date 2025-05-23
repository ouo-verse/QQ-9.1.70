package com.dataline.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.activities.PrinterActivity;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.t;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.en;
import com.tencent.mobileqq.utils.s;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.chatbg.ChatBackgroundDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes2.dex */
public class i extends l {

    /* renamed from: f, reason: collision with root package name */
    LayoutInflater f32450f;

    /* renamed from: h, reason: collision with root package name */
    public PrinterActivity f32451h;

    /* renamed from: i, reason: collision with root package name */
    DataLineHandler f32452i;

    /* renamed from: m, reason: collision with root package name */
    private View.OnClickListener f32453m = new a();
    public View.OnLongClickListener C = new c();
    BubblePopupWindow D = null;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            PrinterItemMsgRecord printerItemMsgRecord = (PrinterItemMsgRecord) ((h) view.getTag()).i();
            if (printerItemMsgRecord != null) {
                FileManagerEntity newEntityByPrinterFileInfo = FileManagerUtil.newEntityByPrinterFileInfo(printerItemMsgRecord);
                ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
                forwardFileInfo.N(10009);
                forwardFileInfo.w(6);
                forwardFileInfo.E(newEntityByPrinterFileInfo.nSessionId);
                forwardFileInfo.y(newEntityByPrinterFileInfo.fileName);
                forwardFileInfo.V(printerItemMsgRecord.uSessionID);
                forwardFileInfo.z(newEntityByPrinterFileInfo.fileSize);
                forwardFileInfo.C(newEntityByPrinterFileInfo.getFilePath());
                Intent intent = new Intent(i.this.f32451h.getApplicationContext(), (Class<?>) FileBrowserActivity.class);
                int i3 = newEntityByPrinterFileInfo.nFileType;
                if (i3 == 0 || i3 == 1) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(String.valueOf(newEntityByPrinterFileInfo.nSessionId));
                    intent.putStringArrayListExtra("Aio_SessionId_ImageList", arrayList);
                }
                intent.putExtra("fileinfo", forwardFileInfo);
                i.this.f32451h.startActivityForResult(intent, 102);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements BubblePopupWindow.OnDismissListener {
        b() {
        }

        @Override // com.tencent.widget.BubblePopupWindow.OnDismissListener
        public void onDismiss() {
            i.this.D = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class c implements View.OnLongClickListener {
        c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            boolean g16 = i.this.g(view);
            EventCollector.getInstance().onViewLongClicked(view);
            return g16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PrinterItemMsgRecord f32457d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f32458e;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                d dVar = d.this;
                PrinterItemMsgRecord printerItemMsgRecord = dVar.f32457d;
                if (printerItemMsgRecord.status < 10) {
                    i.this.f32452i.j3(0, printerItemMsgRecord.uSessionID, true);
                }
                d dVar2 = d.this;
                i.this.f32452i.D.f(dVar2.f32457d);
                i.this.e();
                i.this.notifyDataSetChanged();
                dialogInterface.dismiss();
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class b implements DialogInterface.OnClickListener {
            b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        }

        d(PrinterItemMsgRecord printerItemMsgRecord, Context context) {
            this.f32457d = printerItemMsgRecord;
            this.f32458e = context;
        }

        @Override // android.view.View.OnClickListener
        @SuppressLint({"NewApi"})
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (R.id.bfg == view.getId()) {
                a aVar = new a();
                b bVar = new b();
                Context context = this.f32458e;
                DialogUtil.createCustomDialog(context, 230, context.getString(R.string.f171080c42), this.f32458e.getString(R.string.c3h), R.string.cancel, R.string.c4k, aVar, bVar).show();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public i(PrinterActivity printerActivity, DataLineHandler dataLineHandler) {
        this.f32450f = null;
        this.f32451h = null;
        this.f32452i = null;
        this.f32452i = dataLineHandler;
        this.f32451h = printerActivity;
        this.f32450f = LayoutInflater.from(printerActivity);
        this.f32452i.D.a();
        e();
    }

    @Override // com.dataline.util.l
    public long a(int i3) {
        return this.f32452i.D.f194908e.get(i3).uniseq;
    }

    @Override // com.dataline.util.l
    public long b(int i3) {
        return this.f32452i.D.f194908e.get(i3).time;
    }

    @Override // com.dataline.util.l
    public int c() {
        return this.f32452i.D.f194908e.size();
    }

    protected boolean g(View view) {
        RelativeLayout relativeLayout;
        BubblePopupWindow bubblePopupWindow = this.D;
        if (bubblePopupWindow != null && bubblePopupWindow.isShowing()) {
            return true;
        }
        com.tencent.mobileqq.utils.dialogutils.a aVar = new com.tencent.mobileqq.utils.dialogutils.a();
        h hVar = (h) view.getTag();
        PrinterItemMsgRecord printerItemMsgRecord = (PrinterItemMsgRecord) hVar.i();
        if (printerItemMsgRecord == null || (relativeLayout = hVar.a().f32406m) == null) {
            return false;
        }
        Context context = relativeLayout.getContext();
        aVar.a(R.id.bfg, context.getString(R.string.c3j));
        BubblePopupWindow c16 = s.c(hVar.f32392i, aVar, new d(printerItemMsgRecord, context));
        this.D = c16;
        c16.setOnDismissListener(new b());
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f32452i.D.f194908e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        if (this.f32452i.D.f194908e.size() > i3) {
            this.f32452i.D.f194908e.get(i3);
            return null;
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        PrinterItemMsgRecord printerItemMsgRecord;
        h hVar;
        View view2;
        View view3 = null;
        if (this.f32452i.D.f194908e.size() > i3) {
            printerItemMsgRecord = this.f32452i.D.f194908e.get(i3);
        } else {
            printerItemMsgRecord = null;
        }
        if (printerItemMsgRecord == null) {
            view2 = view;
        } else {
            if (view == null) {
                view = this.f32450f.inflate(R.layout.f167884km, (ViewGroup) null);
                hVar = new h();
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.f1j);
                hVar.f32392i = relativeLayout;
                relativeLayout.setTag(hVar);
                hVar.f32392i.setClickable(true);
                hVar.f32392i.setLongClickable(true);
                hVar.f32392i.setOnClickListener(this.f32453m);
                hVar.f32392i.setOnLongClickListener(this.C);
                hVar.f32392i.setAddStatesFromChildren(true);
                hVar.r((TextView) view.findViewById(R.id.j1x));
                hVar.a().f32406m = (RelativeLayout) view.findViewById(R.id.c_t);
                hVar.a().f32394a = (AsyncImageView) view.findViewById(R.id.c_6);
                hVar.a().f32398e = (TextView) view.findViewById(R.id.ca5);
                hVar.a().f32405l = (ProgressBar) view.findViewById(R.id.c_h);
                hVar.a().f32394a.setDefaultImage(R.drawable.h7o);
                hVar.a().f32394a.setIsDrawRound(false);
                hVar.u((TextView) view.findViewById(R.id.bdp));
                view.setTag(hVar);
            } else {
                hVar = (h) view.getTag();
            }
            hVar.s(printerItemMsgRecord);
            hVar.a().f32394a.setIsDrawRound(false);
            String j3 = q.j(printerItemMsgRecord.filename);
            if (j3 == null) {
                hVar.a().f32394a.setImageResource(R.drawable.f161608ea0);
            } else {
                hVar.a().f32394a.setDefaultImage(FileManagerUtil.getFileIconResId(j3));
                if (FileManagerUtil.getFileType(j3) != 0) {
                    int fileIconResId = FileManagerUtil.getFileIconResId(j3);
                    if (fileIconResId != 0) {
                        hVar.a().f32394a.setImageResource(fileIconResId);
                    }
                } else {
                    hVar.a().f32394a.setAsyncClipSize(128, 128);
                    hVar.a().f32394a.setAsyncImage(printerItemMsgRecord.filename);
                }
            }
            String str = printerItemMsgRecord.filename;
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf >= 0) {
                str = FileManagerUtil.cutLongName(printerItemMsgRecord.filename.substring(lastIndexOf + 1));
            }
            hVar.a().f32398e.setText(str);
            int i16 = printerItemMsgRecord.status;
            if (i16 != 1) {
                if (i16 != 2) {
                    switch (i16) {
                        case 10:
                            hVar.a().f32405l.setVisibility(4);
                            hVar.h().setText(R.string.agi);
                            break;
                        case 11:
                            hVar.a().f32405l.setVisibility(4);
                            hVar.h().setText(R.string.agh);
                            break;
                        case 12:
                            hVar.a().f32405l.setVisibility(4);
                            hVar.h().setText(R.string.agj);
                            break;
                    }
                } else {
                    hVar.a().f32405l.setVisibility(0);
                    hVar.a().f32405l.setProgress((int) (printerItemMsgRecord.progress * 100.0d));
                    hVar.h().setText(R.string.agg);
                }
            } else {
                hVar.a().f32405l.setVisibility(0);
                hVar.h().setText(R.string.agf);
            }
            if (ThemeUtil.isInNightMode(this.f32451h.app)) {
                Object tag = this.f32451h.f32240d0.getTag(R.id.f163834n);
                if (tag instanceof ChatBackgroundDrawable) {
                    hVar.l().setTextColor(ColorStateList.valueOf(t.h(((ChatBackgroundDrawable) tag).getBitmap())));
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("dataline.time", 4, "time[" + printerItemMsgRecord.time + "], uniseq[" + printerItemMsgRecord.uniseq + "], lastShowTime[" + this.f32465d + "], filename[" + printerItemMsgRecord.filename + "], position[" + i3 + "], mapShowTime[" + d(printerItemMsgRecord.uniseq));
            }
            if (d(printerItemMsgRecord.uniseq)) {
                CharSequence d16 = en.d(this.f32451h, 3, printerItemMsgRecord.time * 1000);
                hVar.l().setVisibility(0);
                hVar.l().setText(d16);
            } else {
                hVar.l().setVisibility(8);
            }
            view3 = view;
            view2 = view3;
        }
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view3;
    }
}
