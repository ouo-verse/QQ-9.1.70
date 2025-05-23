package cooperation.qwallet.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class FakeUrl {
    public static final String FAKE_LBUTTON = "lbutton";
    public static final String FAKE_LEFT_URL = "left_url";
    public static final String FAKE_RBUTTON = "rbutton";
    public static final String FAKE_RETURL = "returl";
    public static final String FAKE_TITLE = "title";
    private static final String TAG = "FakeUrl";
    public static final Pattern URL_MATCH_TXT_REGEX = Pattern.compile("<TITLE=\"([^>]+)\",URL=\"([^<]+)\">", 2);
    protected Activity context;

    /* renamed from: fl, reason: collision with root package name */
    protected FakeListener f390853fl = null;
    protected FakeInfo fakeInfo = new FakeInfo();
    private QQCustomDialog mDialog = null;
    private DialogInterface.OnClickListener lListener = new DialogInterface.OnClickListener() { // from class: cooperation.qwallet.plugin.FakeUrl.1
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            FakeUrl fakeUrl = FakeUrl.this;
            FakeListener fakeListener = fakeUrl.f390853fl;
            if (fakeListener != null && fakeListener.onBlHandleFakeurl(fakeUrl.fakeInfo, 0)) {
                QLog.i(FakeUrl.TAG, 2, "bl has handled fake left url...");
            } else {
                FakeUrl fakeUrl2 = FakeUrl.this;
                fakeUrl2.parseFakeUrl(fakeUrl2.fakeInfo.leftUrl);
            }
        }
    };
    private DialogInterface.OnClickListener rListener = new DialogInterface.OnClickListener() { // from class: cooperation.qwallet.plugin.FakeUrl.2
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            FakeUrl fakeUrl = FakeUrl.this;
            FakeListener fakeListener = fakeUrl.f390853fl;
            if (fakeListener != null && fakeListener.onBlHandleFakeurl(fakeUrl.fakeInfo, 1)) {
                QLog.i(FakeUrl.TAG, 2, "bl has handled fake right url...");
            } else {
                FakeUrl fakeUrl2 = FakeUrl.this;
                fakeUrl2.parseFakeUrl(fakeUrl2.fakeInfo.retUrl);
            }
        }
    };
    private boolean mIsCloseAfterClickUrl = true;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class FakeAdapter implements FakeListener {
        @Override // cooperation.qwallet.plugin.FakeUrl.FakeListener
        public boolean onBlHandleFakeurl(FakeInfo fakeInfo, int i3) {
            return false;
        }

        @Override // cooperation.qwallet.plugin.FakeUrl.FakeListener
        public boolean onClickUrl(String str) {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class FakeInfo {
        public Uri leftUri;
        public String leftUrl;
        public String retUrl;
        public int retcode;
        public String retmsg;
        public Uri uri;
        public String leftHost = "";
        public String host = "";
        public String reqUrl = null;
        public JSONObject data = null;
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface FakeListener {
        public static final int BNT_INDEX_LEFT = 0;
        public static final int BNT_INDEX_RIGHT = 1;

        boolean onBlHandleFakeurl(FakeInfo fakeInfo, int i3);

        boolean onClickUrl(String str);
    }

    private Uri parseUrl(String str) {
        Uri parse = Uri.parse(str);
        if (parse == null) {
            return null;
        }
        if (parse.getScheme() == null) {
            QLog.i(TAG, 2, "no scheme...");
            return null;
        }
        return parse;
    }

    public QQCustomDialog getDialog() {
        return this.mDialog;
    }

    public CharSequence getSpanStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
            Matcher matcher = URL_MATCH_TXT_REGEX.matcher(str);
            boolean z16 = false;
            int i3 = 0;
            while (true) {
                int i16 = i3;
                if (!matcher.find()) {
                    break;
                }
                int start = matcher.start(0);
                i3 = matcher.end(0);
                String substring = str.substring(matcher.start(1), matcher.end(1));
                final String substring2 = str.substring(matcher.start(2), matcher.end(2));
                if (i16 != start) {
                    spannableStringBuilder.append((CharSequence) str.substring(i16, start));
                }
                SpannableString spannableString = new SpannableString(substring);
                spannableString.setSpan(new ClickableSpan() { // from class: cooperation.qwallet.plugin.FakeUrl.3
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view) {
                        QLog.i(FakeUrl.TAG, 2, "span click url = " + substring2);
                        if (FakeUrl.this.mIsCloseAfterClickUrl && FakeUrl.this.mDialog != null && FakeUrl.this.mDialog.isShowing()) {
                            FakeUrl.this.mDialog.dismiss();
                        }
                        FakeListener fakeListener = FakeUrl.this.f390853fl;
                        if (fakeListener != null && fakeListener.onClickUrl(substring2)) {
                            return;
                        }
                        FakeUrl.this.parseFakeUrl(substring2);
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setUnderlineText(false);
                    }
                }, 0, substring.length(), 33);
                spannableString.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.color.login_error_url)), 0, substring.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableString);
                z16 = true;
            }
            if (z16) {
                spannableStringBuilder.append((CharSequence) str.substring(i3));
                return spannableStringBuilder;
            }
            return str;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "error msg in qqpay-api module: ", th5);
            return null;
        }
    }

    public void gotoH5(Context context, String str, boolean z16, boolean z17) {
        Intent intent = new Intent();
        intent.putExtra("url", str);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("hide_operation_bar", z16);
        intent.putExtra("hide_more_button", z17);
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
    }

    public void gotoMqq(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse(str));
        context.startActivity(intent);
    }

    public void init(Context context) {
        this.context = (Activity) context;
    }

    public boolean isActivityAlive() {
        Activity activity = this.context;
        if (activity != null && !activity.isDestroyed() && !this.context.isFinishing()) {
            return true;
        }
        return false;
    }

    public boolean onFakePros(String str, String str2, FakeListener fakeListener) {
        try {
            return onFakePros(str, new JSONObject(str2), fakeListener);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "error msg in qqpay-api module: ", e16);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean parseFakeUrl(String str) {
        QLog.i(TAG, 2, "parseFakeUrl url = " + str);
        Uri parse = Uri.parse(str);
        if (parse == null) {
            return false;
        }
        String scheme = parse.getScheme();
        if (scheme == null) {
            QLog.i(TAG, 2, "no scheme...");
            return false;
        }
        if (scheme.startsWith("http")) {
            QLog.i(TAG, 2, "goto h5...");
            gotoH5(this.context, str, true, true);
            return true;
        }
        if (scheme.compareTo(SchemaUtils.SCHEMA_MQQAPI) != 0) {
            return false;
        }
        QLog.i(TAG, 2, "goto mqq...");
        gotoMqq(this.context, str);
        return true;
    }

    public void setIsCloseAfterClickUrl(boolean z16) {
        this.mIsCloseAfterClickUrl = z16;
    }

    public boolean onFakePros(String str, JSONObject jSONObject, FakeListener fakeListener) {
        this.f390853fl = fakeListener;
        FakeInfo fakeInfo = this.fakeInfo;
        fakeInfo.reqUrl = str;
        fakeInfo.data = jSONObject;
        fakeInfo.retcode = jSONObject.optInt("retcode");
        this.fakeInfo.retmsg = jSONObject.optString("retmsg");
        this.fakeInfo.retUrl = jSONObject.optString("returl");
        this.fakeInfo.leftUrl = jSONObject.optString(FAKE_LEFT_URL);
        FakeInfo fakeInfo2 = this.fakeInfo;
        fakeInfo2.uri = parseUrl(fakeInfo2.retUrl);
        FakeInfo fakeInfo3 = this.fakeInfo;
        fakeInfo3.leftUri = parseUrl(fakeInfo3.leftUrl);
        FakeInfo fakeInfo4 = this.fakeInfo;
        Uri uri = fakeInfo4.uri;
        if (uri != null) {
            fakeInfo4.host = uri.getHost();
        }
        FakeInfo fakeInfo5 = this.fakeInfo;
        Uri uri2 = fakeInfo5.leftUri;
        if (uri2 != null) {
            fakeInfo5.leftHost = uri2.getHost();
        }
        QLog.i(TAG, 2, "show fake url dialog...");
        String optString = jSONObject.optString(FAKE_LBUTTON);
        DialogInterface.OnClickListener onClickListener = TextUtils.isEmpty(optString) ? null : this.lListener;
        try {
            QQCustomDialog qQCustomDialog = new QQCustomDialog(this.context, R.style.qZoneInputDialog);
            this.mDialog = qQCustomDialog;
            qQCustomDialog.setContentView(R.layout.f167856jn);
            this.mDialog.setTitle(jSONObject.optString("title", null));
            this.mDialog.setMessageWithoutAutoLink(getSpanStr(this.fakeInfo.retmsg));
            this.mDialog.setNegativeButton(optString, onClickListener);
            this.mDialog.setPositiveButton(jSONObject.optString(FAKE_RBUTTON), this.rListener);
            this.mDialog.setCanceledOnTouchOutside(true);
            this.mDialog.setCancelable(false);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "show dialog fail: ", e16);
        }
        return true;
    }
}
