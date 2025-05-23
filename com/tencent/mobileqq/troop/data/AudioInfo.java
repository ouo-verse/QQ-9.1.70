package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.al;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class AudioInfo extends b implements Serializable, Cloneable {
    static IPatchRedirector $redirector_ = null;
    public static final String AUDIO_DURATION = "duration";
    protected static final String AUDIO_SIZE = "size";
    protected static final String AUDIO_TITLE = "title";
    protected static final String AUDIO_URL = "url";
    private static final long serialVersionUID = 1;
    public int duration;
    public ImageView mAudioIcon;
    private int mAudioType;
    protected int mMaxLayoutLength;
    protected int mMinLayoutLength;
    public String path;
    public long size;
    public String title;
    public String url;

    public AudioInfo(AudioInfo audioInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) audioInfo);
            return;
        }
        this.mMinLayoutLength = 84;
        this.mMaxLayoutLength = 226;
        this.mAudioIcon = null;
        String str = audioInfo.path;
        this.path = str;
        this.title = audioInfo.title;
        this.duration = audioInfo.duration;
        this.url = audioInfo.url;
        this.size = audioInfo.size;
        a(str);
    }

    private void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.endsWith(".slk")) {
                this.mAudioType = 1;
            } else if (lowerCase.endsWith(".amr")) {
                this.mAudioType = 0;
            }
        }
    }

    protected static final String getAudioTime(double d16) {
        int parseTimeToSeconds = parseTimeToSeconds(d16);
        int i3 = parseTimeToSeconds / 60;
        int i16 = parseTimeToSeconds % 60;
        if (i3 > 0) {
            return String.format("%1$d'%2$d\"", Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return String.format("%d\"", Integer.valueOf(parseTimeToSeconds));
    }

    protected static final int parseTimeToSeconds(double d16) {
        if (d16 >= 1000.0d) {
            return (int) ((d16 / 1000.0d) + 0.5d);
        }
        return 0;
    }

    public Object clone() throws CloneNotSupportedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new AudioInfo(this);
    }

    public int getAudioType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mAudioType;
    }

    @Override // com.tencent.mobileqq.troop.data.b
    public String getJsonText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.url)) {
            try {
                jSONObject.put("duration", parseTimeToSeconds(this.duration));
                jSONObject.put("url", this.url);
                jSONObject.put("size", this.size);
            } catch (JSONException unused) {
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("publish_mediaInfo", 2, "AudioInfo getJsonText: " + jSONObject);
        }
        return jSONObject.toString();
    }

    @Override // com.tencent.mobileqq.troop.data.b
    public View getView(Context context, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) onClickListener);
        }
        if (this.duration < 0) {
            return null;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.a2n, (ViewGroup) null);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.a0i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(relativeLayout.getLayoutParams());
        int i3 = this.mMaxLayoutLength;
        int i16 = this.mMinLayoutLength;
        int i17 = this.duration;
        int i18 = (int) ((((i3 - i16) / 60000.0f) * i17) + i16);
        if (i17 < 60000) {
            layoutParams.width = (int) al.a(context, i18);
        } else {
            layoutParams.width = (int) al.a(context, i3);
        }
        layoutParams.height = (int) al.a(context, 41.0f);
        layoutParams.topMargin = (int) al.a(context, 12.0f);
        layoutParams.leftMargin = (int) al.a(context, 3.0f);
        relativeLayout.setLayoutParams(layoutParams);
        int a16 = (int) al.a(context, 5.0f);
        relativeLayout.setPadding(a16, a16, a16, a16);
        inflate.findViewById(R.id.a0l).setOnClickListener(onClickListener);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.a0k);
        this.mAudioIcon = imageView;
        imageView.setOnClickListener(onClickListener);
        TextView textView = (TextView) inflate.findViewById(R.id.a0j);
        textView.setOnClickListener(onClickListener);
        textView.setText(getAudioTime(this.duration));
        return inflate;
    }

    public void setMaxLayout(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.mMaxLayoutLength = i3;
        }
    }

    public void setMinLayout(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.mMinLayoutLength = i3;
        }
    }

    public AudioInfo(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        this.mMinLayoutLength = 84;
        this.mMaxLayoutLength = 226;
        this.mAudioIcon = null;
        this.path = str;
        this.duration = i3;
        this.size = j3;
        a(str);
    }
}
