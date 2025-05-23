package com.tencent.mobileqq.tbstool.fileview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.fileviewer.api.ITBSToolService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tbstool.FileImporter;
import com.tencent.mobileqq.tbstool.TBSToolClientUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.reader.ITbsReaderTool;
import com.tencent.tbs.reader.TbsReaderView;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TbsFileReaderEventCallback implements TbsReaderView.ReaderCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final LocalTbsViewManager.e f291421a;

    /* renamed from: b, reason: collision with root package name */
    private final Activity f291422b;

    /* renamed from: c, reason: collision with root package name */
    private String f291423c;

    /* renamed from: d, reason: collision with root package name */
    private long f291424d;

    /* renamed from: e, reason: collision with root package name */
    private TbsReaderView f291425e;

    public TbsFileReaderEventCallback(LocalTbsViewManager.e eVar, Activity activity, String str, long j3, TbsReaderView tbsReaderView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, eVar, activity, str, Long.valueOf(j3), tbsReaderView);
            return;
        }
        this.f291421a = eVar;
        this.f291422b = activity;
        this.f291423c = str;
        this.f291424d = j3;
        this.f291425e = tbsReaderView;
    }

    private void h(boolean z16, boolean z17) {
        int i3;
        if (z16) {
            ReportController.o(null, "dc00898", "", "", "0X800B00B", "0X800B00B", 0, 0, "", "", "", "");
            return;
        }
        if (z17) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        ReportController.o(null, "dc00898", "", "", "0X800B00C", "0X800B00C", i3, 0, "", "", "", "");
    }

    public void a(Object obj, LocalTbsViewManager.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, obj, (Object) eVar);
            return;
        }
        View e16 = eVar.e();
        if ((obj instanceof ViewGroup) && (e16 instanceof View)) {
            ((ViewGroup) obj).addView(e16);
        }
    }

    public void b(Object obj, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, obj, str, Integer.valueOf(i3));
        } else if (obj != null && (obj instanceof Bundle)) {
            ((Bundle) obj).putInt(str, i3);
        }
    }

    public void c(Object obj, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, obj, str, Boolean.valueOf(z16));
        } else if (obj != null && (obj instanceof Bundle)) {
            ((Bundle) obj).putBoolean(str, z16);
        }
    }

    public void d(Context context, Object obj, Object obj2, String str, LocalTbsViewManager.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, obj, obj2, str, eVar);
            return;
        }
        if (obj != null && (obj instanceof Bundle)) {
            Bundle bundle = (Bundle) obj;
            int i3 = bundle.getInt("typeId", -1);
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                if (i3 == 7) {
                                    a(obj2, eVar);
                                    return;
                                }
                                return;
                            }
                            i.d(context, bundle);
                            return;
                        }
                        ReportController.o(null, "dc00898", "", "", "0X800AF75", "0X800AF75", 0, 0, "", "", "", "");
                        i.a(context, bundle, str, this.f291425e);
                        return;
                    }
                    ReportController.o(null, "dc00898", "", "", "0X800AF74", "0X800AF74", 0, 0, "", "", "", "");
                    return;
                }
                ReportController.o(null, "dc00898", "", "", "0X800AF72", "0X800AF72", 1, 0, "", "", "", "");
                return;
            }
            ReportController.o(null, "dc00898", "", "", "0X800AF71", "0X800AF71", 0, 0, "", "", "", "");
        }
    }

    public void e(int i3, LocalTbsViewManager.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) eVar);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(i3, eVar) { // from class: com.tencent.mobileqq.tbstool.fileview.TbsFileReaderEventCallback.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f291426d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ LocalTbsViewManager.e f291427e;

                {
                    this.f291426d = i3;
                    this.f291427e = eVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TbsFileReaderEventCallback.this, Integer.valueOf(i3), eVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int i16 = this.f291426d;
                    if (i16 != 5001) {
                        if (i16 == 5002) {
                            this.f291427e.g(false);
                            return;
                        }
                        return;
                    }
                    this.f291427e.g(true);
                }
            });
        }
    }

    public void f(Object obj, Activity activity, LocalTbsViewManager.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, obj, activity, eVar);
        } else {
            if (!(obj instanceof View)) {
                return;
            }
            eVar.d((View) obj);
        }
    }

    public void g(Object obj, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, obj, str, Long.valueOf(j3));
        } else {
            if (!(obj instanceof Integer) || ((Integer) obj).intValue() != 0) {
                return;
            }
            if (this.f291425e.openFile(i.c(this.f291422b, str, j3)) == 0) {
                z16 = true;
            }
            h(true, z16);
        }
    }

    @Override // com.tencent.tbs.reader.TbsReaderView.ReaderCallback
    public void onCallBackAction(Integer num, Object obj, Object obj2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, num, obj, obj2);
            return;
        }
        int intValue = num.intValue();
        if (intValue != 12) {
            boolean z16 = true;
            if (intValue != 19) {
                if (intValue != 5000) {
                    if (intValue != 5012) {
                        if (intValue != 5045) {
                            if (intValue != 5024) {
                                if (intValue != 5025) {
                                    switch (intValue) {
                                        case 50002:
                                            TBSToolClientUtils.f291401a.I(obj);
                                            break;
                                        case 50003:
                                            TBSToolClientUtils.f291401a.C(obj);
                                            break;
                                        default:
                                            switch (intValue) {
                                                case 50006:
                                                    if (obj instanceof Bundle) {
                                                        String string = ((Bundle) obj).getString("filePath", "");
                                                        if (!TextUtils.isEmpty(string)) {
                                                            ((ITBSToolService) QRoute.api(ITBSToolService.class)).saveFileToWeiYun(string);
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                case 50007:
                                                    FileImporter.f291396a.e(this.f291422b, obj, obj2);
                                                    break;
                                                case 50008:
                                                    TBSToolClientUtils.f291401a.B(obj);
                                                    break;
                                                case 50009:
                                                    TBSToolClientUtils.f291401a.J(this.f291422b, obj);
                                                    break;
                                                case 50010:
                                                    TBSToolClientUtils.f291401a.t(obj, obj2);
                                                    break;
                                                case 50011:
                                                    LocalTbsViewManager.e eVar = this.f291421a;
                                                    if (eVar != null) {
                                                        eVar.f();
                                                        break;
                                                    }
                                                    break;
                                                case 50012:
                                                    TBSToolClientUtils.f291401a.D(this.f291422b, obj);
                                                    break;
                                                default:
                                                    switch (intValue) {
                                                        case 50014:
                                                            if (obj instanceof Bundle) {
                                                                try {
                                                                    ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).jumpToMyFile(this.f291422b, Long.parseLong(((Bundle) obj).getString("fileId", "0")));
                                                                    break;
                                                                } catch (Throwable th5) {
                                                                    QLog.d("TbsFileReaderEventCallback", 1, th5, new Object[0]);
                                                                    break;
                                                                }
                                                            }
                                                            break;
                                                        case 50015:
                                                            LocalTbsViewManager.e eVar2 = this.f291421a;
                                                            if (eVar2 != null) {
                                                                eVar2.b(false);
                                                                break;
                                                            }
                                                            break;
                                                        case ITbsReaderTool.HOST_TOOL_SHOW_ACTION_BAR /* 50016 */:
                                                            LocalTbsViewManager.e eVar3 = this.f291421a;
                                                            if (eVar3 != null) {
                                                                eVar3.b(true);
                                                                break;
                                                            }
                                                            break;
                                                    }
                                            }
                                    }
                                } else {
                                    h(false, false);
                                }
                            } else {
                                LocalTbsViewManager.e eVar4 = this.f291421a;
                                if (eVar4 != null) {
                                    b(obj2, "is_bar_show", !eVar4.h() ? 1 : 0);
                                }
                            }
                        } else {
                            b(obj2, "TitleHeight", (int) this.f291422b.getResources().getDimension(R.dimen.title_bar_height));
                        }
                    } else {
                        g(obj, this.f291423c, 0L);
                    }
                } else {
                    c(obj2, "is_bar_animating", false);
                }
            } else if (obj != null && (obj instanceof Integer)) {
                if (((Integer) obj).intValue() != 0) {
                    z16 = false;
                }
                h(false, z16);
            }
        } else {
            f(obj, this.f291422b, this.f291421a);
        }
        e(num.intValue(), this.f291421a);
        if (num.intValue() == 6001) {
            d(this.f291422b, obj, obj2, this.f291423c, this.f291421a);
        }
    }
}
