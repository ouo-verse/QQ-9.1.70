package com.tencent.mobileqq.winkpublish.model;

import android.media.ExifInterface;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes21.dex */
public class ExtendExifInterface extends ExifInterface {
    private String mFilePath;

    public ExtendExifInterface(String str) throws IOException {
        super(str);
        this.mFilePath = str;
    }

    public String getFilePath() {
        return this.mFilePath;
    }
}
