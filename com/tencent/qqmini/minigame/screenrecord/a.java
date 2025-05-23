package com.tencent.qqmini.minigame.screenrecord;

import android.content.Context;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final File f346680a;

    /* renamed from: b, reason: collision with root package name */
    private final SimpleDateFormat f346681b = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.US);

    public a(Context context) {
        this.f346680a = new File(context.getFilesDir(), "minigame_screenrecord");
    }

    public File a() {
        if (!this.f346680a.exists()) {
            this.f346680a.mkdirs();
        }
        return new File(this.f346680a, "minigame_" + this.f346681b.format(Calendar.getInstance().getTime()) + ".mp4");
    }

    public long b() {
        return FileUtils.deleteDirectory(this.f346680a.getAbsolutePath());
    }
}
