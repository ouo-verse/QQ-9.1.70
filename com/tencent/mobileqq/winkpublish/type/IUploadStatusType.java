package com.tencent.mobileqq.winkpublish.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes21.dex */
public @interface IUploadStatusType {
    public static final int UPLOAD_STATUS_BEFORE_UPLOAD = 5;
    public static final int UPLOAD_STATUS_FAILED = 3;
    public static final int UPLOAD_STATUS_PUBLISHING = 2;
    public static final int UPLOAD_STATUS_SUCCESS = 4;
    public static final int UPLOAD_STATUS_UN_DEFINED = 0;
    public static final int UPLOAD_STATUS_UPLOADING = 1;
}
