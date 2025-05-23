package com.tencent.biz.richframework.publish.base.interfaces;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H'\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H'\u00a2\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u0001H'\u00a2\u0006\u0004\b\n\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u0001H'\u00a2\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u0001H'\u00a2\u0006\u0004\b\f\u0010\u0007J\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u0001H'\u00a2\u0006\u0004\b\r\u0010\u0007J'\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH'\u00a2\u0006\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWUploadDelegate;", "M", UserInfo.SEX_FEMALE, "", "publishModel", "", "missionDidStart", "(Ljava/lang/Object;)V", "missionDidFinish", "publishFile", "fileDidStartUpload", "fileDidFinishUpload", "fileDidFailUpload", "fileDidCancelUpload", "", "bytesUploaded", "bytesTotal", "fileDidUpdateProgress", "(Ljava/lang/Object;JJ)V", "rfw-upload_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public interface IRFWUploadDelegate<M, F> {
    void fileDidCancelUpload(F publishFile);

    void fileDidFailUpload(F publishFile);

    void fileDidFinishUpload(F publishFile);

    void fileDidStartUpload(F publishFile);

    void fileDidUpdateProgress(F publishFile, long bytesUploaded, long bytesTotal);

    void missionDidFinish(M publishModel);

    void missionDidStart(M publishModel);
}
