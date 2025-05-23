package com.tencent.freesia;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public interface ConfigParserBridge {
    @Nullable
    ConfigParser create(@NonNull String str);

    @NonNull
    ArrayList<String> getAllGroups();

    @NonNull
    ArrayList<String> getAllGroupsNOLogin();

    void onReceive(boolean z16, boolean z17, @NonNull String str, @NonNull ArrayList<String> arrayList);
}
