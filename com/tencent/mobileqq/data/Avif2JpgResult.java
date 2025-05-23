package com.tencent.mobileqq.data;

/* compiled from: P */
/* loaded from: classes10.dex */
public class Avif2JpgResult {
    private ConvertToJpg mConvertToJpg = ConvertToJpg.INIT;
    private GenerateThumb mGenerateThumb = GenerateThumb.INIT;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public enum ConvertToJpg {
        INIT,
        PATH_INVALID,
        SRC_FILE_NOT_EXIST,
        SRC_FILE_NOT_AVIF,
        AVIF_SO_NOT_LOADED,
        YUV_SIZE_INVALID,
        YUV_FAIL,
        FAIL_WITH_OOM,
        FAIL_WITH_EXCEPTION,
        FAIL_WITH_DEBUG_EXCEPTION,
        FAIL,
        SUCCESS_BY_YUV,
        SUCCESS_BY_RGB
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public enum GenerateThumb {
        INIT,
        SUCCESS,
        FAIL
    }

    public ConvertToJpg getConvertToJpg() {
        return this.mConvertToJpg;
    }

    public GenerateThumb getGenerateThumb() {
        return this.mGenerateThumb;
    }

    public Avif2JpgResult setConvertToJpg(ConvertToJpg convertToJpg) {
        this.mConvertToJpg = convertToJpg;
        return this;
    }

    public Avif2JpgResult setGenerateThumb(GenerateThumb generateThumb) {
        this.mGenerateThumb = generateThumb;
        return this;
    }

    public String toString() {
        return "Avif2JpgResult{mConvertToJpg=" + this.mConvertToJpg + ", mGenerateThumb=" + this.mGenerateThumb + '}';
    }
}
