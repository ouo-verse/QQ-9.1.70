package com.tencent.mobileqq.triton.internal.game;

import com.tencent.mobileqq.triton.script.ScriptFile;
import java.io.File;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"toNativeType", "", "", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "pluginId", "(Lcom/tencent/mobileqq/triton/script/ScriptFile;Ljava/lang/String;)[Ljava/lang/String;", "Triton_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class ScriptPackageBridgesKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String[] toNativeType(@NotNull ScriptFile scriptFile, String str) {
        String[] strArr;
        String str2 = null;
        if (scriptFile instanceof ScriptFile.Path) {
            strArr = new String[5];
            ScriptFile.Path path = (ScriptFile.Path) scriptFile;
            strArr[0] = path.getName();
            strArr[1] = path.getPath().getAbsolutePath();
            strArr[2] = null;
            File codeCache = path.getCodeCache();
            if (codeCache != null) {
                str2 = codeCache.getAbsolutePath();
            }
            strArr[3] = str2;
            strArr[4] = str;
        } else if (scriptFile != null) {
            ScriptFile.Content content = (ScriptFile.Content) scriptFile;
            strArr = new String[4];
            strArr[0] = content.getName();
            strArr[1] = null;
            File codeCache2 = content.getCodeCache();
            if (codeCache2 != null) {
                str2 = codeCache2.getAbsolutePath();
            }
            strArr[2] = str2;
            strArr[3] = str;
        } else {
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.triton.script.ScriptFile.Content");
        }
        return strArr;
    }
}
