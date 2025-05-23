package com.tencent.mobileqq.pttlogic.api.impl;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.b;
import com.tencent.mobileqq.ptt.j;
import com.tencent.mobileqq.ptt.l;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.transfile.api.TransFileControllerBusHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.StatableSpanTextView;
import mqq.app.AppRuntime;

/* loaded from: classes16.dex */
public class PttUtilsImpl implements IPttUtils {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "PttUtilsImpl";

    /* loaded from: classes16.dex */
    class a implements ClickableColorSpanTextView.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f261309a;

        /* renamed from: com.tencent.mobileqq.pttlogic.api.impl.PttUtilsImpl$a$a, reason: collision with other inner class name */
        /* loaded from: classes16.dex */
        class C8275a implements o {
            static IPatchRedirector $redirector_;

            C8275a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // com.tencent.mobileqq.qroute.route.o
            public void onError(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            }

            @Override // com.tencent.mobileqq.qroute.route.o
            public void onSuccess() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }

        a(Context context) {
            this.f261309a = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PttUtilsImpl.this, (Object) context);
            }
        }

        @Override // com.tencent.mobileqq.widget.ClickableColorSpanTextView.a
        public void a(ClickableColorSpanTextView clickableColorSpanTextView, StatableSpanTextView.StatableForegroundColorSpan statableForegroundColorSpan) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) clickableColorSpanTextView, (Object) statableForegroundColorSpan);
                return;
            }
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(this.f261309a, RouterConstants.UI_ROUTE_BROWSER);
            activityURIRequest.extra().putString("url", IQQRecorderUtils.ABNORMAL_RECORD_URL);
            QRoute.startUri(activityURIRequest, new C8275a());
        }
    }

    public PttUtilsImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPttUtils
    public com.tencent.mobileqq.ptt.a creatPttAudioDataManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.ptt.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new j();
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPttUtils
    public b createPttVoiceChangePreSender(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
        }
        return new l(appRuntime);
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPttUtils
    public int getReceivedPTTStatus(AppInterface appInterface, MessageForPtt messageForPtt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) appInterface, (Object) messageForPtt)).intValue();
        }
        String str = messageForPtt.url;
        if (str == null) {
            return 2005;
        }
        if (str.startsWith(AppConstants.SDCARD_ROOT) && FileUtils.fileExists(messageForPtt.getLocalFilePath())) {
            return 2003;
        }
        int findProcessorFileStatus = TransFileControllerBusHelper.findProcessorFileStatus(appInterface, messageForPtt.frienduin, messageForPtt.getLocalFilePath(), messageForPtt.uniseq);
        if (findProcessorFileStatus == -1 && messageForPtt.fileSize == -4) {
            return 2005;
        }
        return findProcessorFileStatus;
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPttUtils
    public void showDialogAboutMeizuRecordPermission(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        SpannableString spannableString = new SpannableString(context.getString(R.string.f20343507));
        spannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(context.getResources().getColor(R.color.f157037i4), context.getResources().getColor(R.color.f157042i9)), spannableString.length() - 7, spannableString.length() - 1, 33);
        DialogUtil.createContentClickableDialog(context, context.getString(R.string.f20342506), spannableString, 0, R.string.f171151ok, null, null, new a(context)).show();
    }
}
