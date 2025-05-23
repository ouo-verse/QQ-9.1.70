package com.tencent.mobileqq.colornote.settings;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.api.impl.ColorNoteControllerImpl;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.IColorNoteHelper;
import com.tencent.mobileqq.colornote.settings.HistoryFormItem;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.filemanager.api.IFileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private List<ColorNote> f201539a;

    /* renamed from: b, reason: collision with root package name */
    private c f201540b;

    /* renamed from: c, reason: collision with root package name */
    private int f201541c;

    /* renamed from: d, reason: collision with root package name */
    private AppRuntime f201542d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.colornote.settings.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class ViewOnClickListenerC7460a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ HistoryFormItem f201543d;

        ViewOnClickListenerC7460a(HistoryFormItem historyFormItem) {
            this.f201543d = historyFormItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ColorNote colorNote = (ColorNote) a.this.f201539a.get(this.f201543d.e());
            Bundle bundle = new Bundle();
            if (a.this.f201541c == 17104896 && (colorNote.getServiceType() == 16908288 || colorNote.getServiceType() == 16908290)) {
                bundle.putBoolean("isFromFavourite", true);
            }
            ColorNoteControllerImpl.launch(view.getContext(), colorNote, bundle);
            if (QLog.isColorLevel()) {
                QLog.d("BaseSectionAdapter", 2, "getAllViews#onClick: index: " + this.f201543d.e());
            }
            ReportController.o(null, "dc00898", "", "", "0X800AA7F", "0X800AA7F", com.tencent.mobileqq.colornote.data.a.i(a.this.f201541c), 0, String.valueOf(this.f201543d.e() + 1), "", "", "");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b implements HistoryFormItem.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HistoryFormItem f201545a;

        b(HistoryFormItem historyFormItem) {
            this.f201545a = historyFormItem;
        }

        @Override // com.tencent.mobileqq.colornote.settings.HistoryFormItem.b
        public void a(View view, int i3, boolean z16) {
            ColorNote colorNote;
            ColorNoteCurd colorNoteCurd = new ColorNoteCurd();
            if (((IColorNoteHelper) a.this.f201542d.getRuntimeService(IColorNoteHelper.class, "all")).canAddColorNote() && this.f201545a.h()) {
                ColorNote colorNote2 = (ColorNote) a.this.f201539a.get(i3);
                try {
                    colorNote = (ColorNote) colorNote2.clone();
                } catch (CloneNotSupportedException e16) {
                    e16.printStackTrace();
                    colorNote = null;
                }
                if (colorNote != null) {
                    colorNote.setType(0);
                    colorNoteCurd.a(colorNote.parseBundle());
                }
                this.f201545a.setEnable(false);
                a.this.e(colorNote2, i3);
                QQToast.makeText(view.getContext(), 2, HardCodeUtil.qqStr(R.string.vz5), 500).show();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c {
        void a();
    }

    public a(AppRuntime appRuntime) {
        this.f201542d = appRuntime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ColorNote colorNote, int i3) {
        String str;
        int i16;
        ReportController.o(null, "dc00898", "", "", "0X800AA80", "0X800AA80", com.tencent.mobileqq.colornote.data.a.i(this.f201541c), 0, String.valueOf(i3), "", "", "");
        int serviceType = colorNote.getServiceType();
        int i17 = 9;
        boolean z16 = false;
        z16 = false;
        byte b16 = 0;
        int i18 = 0;
        int i19 = 1;
        if (serviceType == 17039360) {
            if (!TextUtils.isEmpty(colorNote.getSubType()) && ColorNoteSmallScreenUtil.f(colorNote.getSubType()) == 4) {
                str = "0X800AA83";
                b16 = 1;
            } else {
                str = "0X800AA82";
            }
            int fileType = ((IFileManagerUtil) QRoute.api(IFileManagerUtil.class)).getFileType(colorNote.getMainTitle());
            if (fileType != 3) {
                if (fileType != 4) {
                    i19 = 6;
                    if (fileType != 6) {
                        if (fileType != 7) {
                            if (fileType == 9) {
                                i19 = 4;
                            }
                        } else {
                            i19 = 2;
                        }
                    } else {
                        i19 = 3;
                    }
                } else {
                    i19 = 5;
                }
            }
            if (b16 != 0) {
                i16 = 7;
            } else {
                i16 = i19;
            }
            ReportController.o(null, "dc00898", "", "", str, str, i16, 0, "", "", "", "");
            return;
        }
        if (serviceType == 17104896) {
            String[] split = colorNote.getSubType().split("-");
            if (split.length > 1) {
                i18 = Integer.parseInt(split[1]);
            }
            ReportController.o(null, "dc00898", "", "", "0X800AA83", "0X800AA83", i18, 0, "", "", "", "");
            return;
        }
        if (serviceType == 16908288) {
            if (colorNote.getReserve() != null) {
                try {
                    z16 = new JSONObject(new String(colorNote.getReserve())).getBoolean(IPublicAccountBrowser.H5_TYPE_READ_IN_JOY);
                } catch (JSONException e16) {
                    QLog.e("BaseSectionAdapter", 1, e16, new Object[0]);
                }
            }
            if (this.f201541c == 17104896) {
                if (!z16) {
                    i17 = 8;
                }
                ReportController.o(null, "dc00898", "", "", "0X800AA83", "0X800AA83", i17, 0, "", "", "", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<HistoryFormItem> f(Context context) {
        f fVar = new f();
        ArrayList<HistoryFormItem> arrayList = new ArrayList();
        Iterator<ColorNote> it = this.f201539a.iterator();
        while (it.hasNext()) {
            arrayList.add(fVar.a(context, it.next()));
        }
        int i3 = 0;
        for (HistoryFormItem historyFormItem : arrayList) {
            historyFormItem.setIndex(i3);
            historyFormItem.setItemOnClickListener(new ViewOnClickListenerC7460a(historyFormItem));
            historyFormItem.setOnIconClickListener(new b(historyFormItem));
            i3++;
        }
        return arrayList;
    }

    public void g(List<ColorNote> list, int i3) {
        this.f201541c = i3;
        this.f201539a = list;
        this.f201540b.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(c cVar) {
        this.f201540b = cVar;
    }
}
