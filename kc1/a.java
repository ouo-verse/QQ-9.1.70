package kc1;

import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.api.IFileModel;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    private static IFileModel a() {
        return (IFileModel) QRoute.api(IFileModel.class);
    }

    public static b b(MessageForFile messageForFile) {
        return a().newFileModel(messageForFile);
    }

    public static b c(FileManagerEntity fileManagerEntity) {
        return a().newFileModel(fileManagerEntity);
    }

    public static b d(String str) {
        return a().newFileModel(str);
    }
}
