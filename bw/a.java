package bw;

import com.tencent.av.config.api.IConfigParser;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f29284a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f29285b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f29286c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f29287d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f29288e = 0;

    public boolean a(IConfigParser iConfigParser) {
        try {
            this.f29284a = iConfigParser.getIntValue("sharp/small_window/version", 0);
            this.f29285b = iConfigParser.getIntValue("sharp/small_window/close_flag", 0);
            this.f29286c = iConfigParser.getIntValue("sharp/small_window/use_textureview", -1);
            this.f29287d = iConfigParser.getIntValue("sharp/small_window/close_video", 0);
            this.f29288e = iConfigParser.getIntValue("sharp/small_window/close_audio", 0);
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenConfigParser", 2, "value_version = " + this.f29284a + " , value_close_flag = " + this.f29285b + " , value_use_textureview = " + this.f29286c + " ,value_close_video = " + this.f29287d + " , value_close_audio = " + this.f29288e);
            }
            return true;
        } catch (Exception unused) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.e("SmallScreenConfigParser", 2, "parseConfig --> Error");
            return false;
        }
    }
}
