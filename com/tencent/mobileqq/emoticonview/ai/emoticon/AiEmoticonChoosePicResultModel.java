package com.tencent.mobileqq.emoticonview.ai.emoticon;

import androidx.fragment.app.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\bH\u00c6\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/ai/emoticon/AiEmoticonChoosePicResultModel;", "", "localPath", "", "fileSize", "", "picUrl", "sex", "", "(Ljava/lang/String;JLjava/lang/String;Z)V", "getFileSize", "()J", "getLocalPath", "()Ljava/lang/String;", "getPicUrl", "getSex", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final /* data */ class AiEmoticonChoosePicResultModel {
    static IPatchRedirector $redirector_;
    private final long fileSize;

    @NotNull
    private final String localPath;

    @NotNull
    private final String picUrl;
    private final boolean sex;

    public AiEmoticonChoosePicResultModel(@NotNull String localPath, long j3, @NotNull String picUrl, boolean z16) {
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, localPath, Long.valueOf(j3), picUrl, Boolean.valueOf(z16));
            return;
        }
        this.localPath = localPath;
        this.fileSize = j3;
        this.picUrl = picUrl;
        this.sex = z16;
    }

    public static /* synthetic */ AiEmoticonChoosePicResultModel copy$default(AiEmoticonChoosePicResultModel aiEmoticonChoosePicResultModel, String str, long j3, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = aiEmoticonChoosePicResultModel.localPath;
        }
        if ((i3 & 2) != 0) {
            j3 = aiEmoticonChoosePicResultModel.fileSize;
        }
        long j16 = j3;
        if ((i3 & 4) != 0) {
            str2 = aiEmoticonChoosePicResultModel.picUrl;
        }
        String str3 = str2;
        if ((i3 & 8) != 0) {
            z16 = aiEmoticonChoosePicResultModel.sex;
        }
        return aiEmoticonChoosePicResultModel.copy(str, j16, str3, z16);
    }

    @NotNull
    public final String component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.localPath;
    }

    public final long component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.fileSize;
    }

    @NotNull
    public final String component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.picUrl;
    }

    public final boolean component4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.sex;
    }

    @NotNull
    public final AiEmoticonChoosePicResultModel copy(@NotNull String localPath, long fileSize, @NotNull String picUrl, boolean sex) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (AiEmoticonChoosePicResultModel) iPatchRedirector.redirect((short) 10, this, localPath, Long.valueOf(fileSize), picUrl, Boolean.valueOf(sex));
        }
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        return new AiEmoticonChoosePicResultModel(localPath, fileSize, picUrl, sex);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof AiEmoticonChoosePicResultModel)) {
            return false;
        }
        AiEmoticonChoosePicResultModel aiEmoticonChoosePicResultModel = (AiEmoticonChoosePicResultModel) other;
        if (Intrinsics.areEqual(this.localPath, aiEmoticonChoosePicResultModel.localPath) && this.fileSize == aiEmoticonChoosePicResultModel.fileSize && Intrinsics.areEqual(this.picUrl, aiEmoticonChoosePicResultModel.picUrl) && this.sex == aiEmoticonChoosePicResultModel.sex) {
            return true;
        }
        return false;
    }

    public final long getFileSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.fileSize;
    }

    @NotNull
    public final String getLocalPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.localPath;
    }

    @NotNull
    public final String getPicUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.picUrl;
    }

    public final boolean getSex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.sex;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        int hashCode = ((((this.localPath.hashCode() * 31) + a.a(this.fileSize)) * 31) + this.picUrl.hashCode()) * 31;
        boolean z16 = this.sex;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "AiEmoticonChoosePicResultModel(localPath=" + this.localPath + ", fileSize=" + this.fileSize + ", picUrl=" + this.picUrl + ", sex=" + this.sex + ')';
    }
}
