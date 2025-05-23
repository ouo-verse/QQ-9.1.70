package ar;

import com.tencent.aelight.camera.ae.j;
import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import java.io.File;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final String f26764a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f26765b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f26766c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f26767d;

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(j.a.f65592c);
        String str = File.separator;
        sb5.append(str);
        sb5.append("ae_editor");
        String sb6 = sb5.toString();
        f26764a = sb6;
        f26765b = sb6 + str + ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS;
        f26766c = sb6 + str + JsonUtils.KEY_BGM;
        f26767d = sb6 + str + "comic";
    }
}
