package com.huawei.hms.health;

import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aact implements OnCompleteListener {
    private TaskCompletionSource aab;
    private aacz aaba;

    public aact(TaskCompletionSource taskCompletionSource, aacz aaczVar) {
        this.aab = taskCompletionSource;
        this.aaba = aaczVar;
    }

    @Override // com.huawei.hmf.tasks.OnCompleteListener
    public void onComplete(Task task) {
        if (task == null) {
            this.aab.setResult(this.aaba.aab(new NullPointerException()));
        } else if (task.isSuccessful()) {
            this.aab.setResult(this.aaba.aab(task.getResult()));
        } else {
            this.aab.setException(task.getException());
        }
    }
}
