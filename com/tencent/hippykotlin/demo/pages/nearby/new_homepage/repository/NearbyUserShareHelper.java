package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository;

import com.tencent.hippykotlin.demo.pages.nearby.interactive.repository.IStrangerArkRepo;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.repository.JiebanArkRepo;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.repository.NBPInteractiveRepo;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyUserShareHelper {
    public final Function2<Boolean, String, Unit> onError;
    public final Function3<Integer, Boolean, String, Unit> onSuccess;
    public final String pagerId;
    public final IStrangerArkRepo repo;

    public NearbyUserShareHelper(String str, int i3, String str2, Function3 function3, Function2 function2) {
        IStrangerArkRepo iStrangerArkRepo;
        this.pagerId = str;
        this.onSuccess = function3;
        this.onError = function2;
        if (i3 == 1) {
            iStrangerArkRepo = JiebanArkRepo.INSTANCE;
        } else if (i3 != 2) {
            iStrangerArkRepo = NBPInteractiveRepo.INSTANCE;
        } else {
            iStrangerArkRepo = NBPInteractiveRepo.INSTANCE;
        }
        this.repo = iStrangerArkRepo;
    }
}
