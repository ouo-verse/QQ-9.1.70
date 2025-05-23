package com.tencent.ams.fusion.widget.cny2025.twist;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class CNYTwistArrowLayer extends GroupLayer {
    static IPatchRedirector $redirector_ = null;
    public static final int ARROW_HEIGHT = 42;
    public static final int ARROW_MARGIN_BOTTOM = 139;
    public static final int ARROW_MARGIN_LEFT = -4;
    public static final int ARROW_MARGIN_RIGHT = -4;
    public static final int ARROW_WIDTH = 86;
    private static final int CLIP_ARC_CENTER_MARGIN_BOTTOM = -213;
    private static final int CLIP_ARC_RADIUS = 411;
    public static final String FILL_LEFT_ARROW_BASE64 = "iVBORw0KGgoAAAANSUhEUgAAAVgAAACoCAMAAACSVwbfAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAAJcEhZcwAALEsAACxLAaU9lqkAAABIUExURUdwTP///////////////////////////////////////////////////////////////////////////////////////////wV68vgAAAAXdFJOUwB/gI9AP98Q77+fIG9fYM+vUC8wH3BPHlUtVgAABDxJREFUeNrtndlS4zAQRXHsyJJjbIcA+v8/nQFmWOIQa+nOYp37TMHUSdft2y1p8vCAEEIIXUvtxvrxEQ7icv5NZgcJWQ3+nzrQiqr+D9bbDTQE1fkvGaxWwQre5fADsVDgfwqrlZI5ImteYCLcvbBaUe39XPiBgsl+qAat0OiFH4ir8qdlGthkqfG/CavNk/2VrN+04JE2Waw2W70/JxaKydr588JqFUyWhWKOOr8krDZJg1/WhB9ITbVYbb7GILL4QbRq70F72akWP8gzWRtM1tdMuUJT7cwPIBuuKgKsr+AVqMNmjAFrIBZir01tfZws1Bap9i6W6tutDsCdz1gb55O0hZ2kAXxFWfCJGsCnGBFkDYCwdY5qbXymGA9mBrDvrM8XaxhJW2U4OKld77yU6FxizYqopdOsfg6zFOw7VeuFRdRqFajSudqmU6BaetRqByWq3k8lU3VaVAuOWrpUS41aAlRtx3VOeaqu2s7f0pXdudpmyqRqp8ePlVVN1JJLVqb+OmnZn/m5V2arGAPon398THQuAaqfBvBNrviolU213p46CajKXhLsNiY/AZz+vAqOWm3mfvXIVo9+uS00arV5ZwHWPS4cBboSo1a7zxoDbLddPmA9/ZbuiXZ1plkF/ZVDYVGr2eRQNVX4bStbUNTKa1euirrD1pUStfLalaueI//eUEbnytoEuD7hNlBbQNTKMtYkqm86nj1GjFWA6onV4ao619/Eeh2q86l2TVErJ7FmUp2Z7HqWBG3cyyBhqrOptsICZKgerQ5N6RYgRvXIZFcQtTIGAVfJ3l63K7r60rj0PcCz9D9mWkvU2iUPArbSeMvWryJqpVtA6CYw/oNeQdRK7le2U3x36e68cyUXq3Wvqo+tDuaejSB5cSUZrX4zg85N91mvyfOVdLRa2T7Q3VIIWM8ywN5euyq3WBcvBFCsGOuNFCvGqhED7ARVhcx6gcRa4DbAyq+t1lWsSdsAstVCsaYdtWABGunKVk+gk09XDgtQSFdYgEbDUjsQKNsDKFaNhkW/Upmw6FdLSgmtlsWVhgdQrBoeQLGq5ACKVcMDKFaVWYBi1fAAinXZA/qRYr0Ja6VYQ+IVxXoT1mprtgEK1srqSsNaORcM0CH+G5poWBrWSsPSwErDCrLW2P9CbKRhaXQsPCBAu9iORcNSsVZCqw5WPCBAg4v1AL6KRSEIGDxAIwjgARpYuXelkq+IVypBgKdtOljxAAWstiZeaWDFWjWmAaw1LF8NBmu9fmzlFEsDK9YK1vvB6viqdhWsWCtY7wUrM5YOVjoWWO8GqyEIaGClY4EVrIVj7bgqGKgXGxMEiK2h5TqRr1Q0gVXHB8CqYwQGrCoauNWmI8fsqiPL2YCOGLKuAhasyTJg1VEHVh01YL2kF4BVpWTBKqIKrJcgC1ZBHQxYlbStnTEjT7IQQgjduv4A4oXZjpuBMrkAAAAASUVORK5CYII=";
    public static final String FILL_RIGHT_ARROW_BASE64 = "iVBORw0KGgoAAAANSUhEUgAAAVgAAACoCAMAAACSVwbfAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAAJcEhZcwAALEsAACxLAaU9lqkAAABFUExURUdwTP///////////////////////////////////////////////////////////////////////////////////////1fUNLcAAAAWdFJOUwDvQBC/YF/fIJ8/z6+PMG9/UE+AcJAcwAM9AAAEUklEQVR42u2di3baMBBEMQhkIxtIoPv/n9q0SZuGGtBrcox95wN60ns2s7MryVmtEEIITUeXYP4MhtpaO/ulDhJV1fb2oTUw6mlzbv5wtQEc1bT1ZoBVmesfvUKkjgt09lUtTCqb67sCUGq4gLdrYbHlOjj7X3u4lLrADxsTYErn12aUq4NMmbkGG9cRNiXzq7NbOkCnYsT6VAOe/Pn1NlazHj515tdr7SCUZ66d3RfzbG1zfZcHUoZevD0SxwfVzZWVYdX59VobSKXpobkyz2a5gLc4sTKsNL+yMpSbK/Nsarn6eK5YbIK6BK6sDBPUpIANR5aGsbJE+Y4bRlFylq5+xyrmcYS1LIWBwhWU7IcpvEDvXt6yAmEKd3SyIjmSwq3Rq7FCkRTGdbFyvRkuG8V6/QvDlUSuMcOF7Rf1Vk+Mvf9GrsZqyjM9VIpcBIWbkcubwVahrSnUMPXWilyw1UWuMbZLHh46U6rfLZbtg5VB52GriFxhtTqcin14mX57N3K9X4Fpt31DL6vavz6vwOxLTWGBbF3kLcPD0TE7pOgQfwWm2BSWxXZIugLzWmgKvlvMHuxm5Lp1y3A/hDK2x4Xsby/ptwzbQsMNy9iNh5xXc2+Gy7lDVuR6/Gpu89oVNbN+9hHM5b+aK0u4c48JY6c08a/m9oMnJsSvDJJezR2KgsKMW9lI5Ep9NdceQ1Erm+kW7FLj1Vy7dSXbhHnaravzoa0itr6boSWsq72aK2I7Q7vtKr6aK2I7t3R7FbmK/7kCtjNLYKfar+aK2M7IEr6c0lR6NVfCtp/Nl2heJB/aardh8ZbgRF+BKZgd5pES1roPbbX5+4Q5DA6D8kNbh+w9mB+evWz/rgxE/5H8HaN78k52kn84Ons3/uSd7Hf/aqS/eZvsM52n7mRb507yHz8/3nJh/HEE88xkImXHBMo2IiY0lK2qlTnKVtbKPGU7MbulbGMmB8p2YumWso1gm2cJYccHKSISGCfnMksIS1yATdgSnn9v+y0poaeRTWpwIH/JdgkNjUy2S6CRyToZjhClrLLFEaLK9uRxhAkFMH+hbFUBDEeQrRJwBFnZkhF0ZYsjyEJCzx4hLiS4DEcAm2gk82ccQTWSYbaxZZu8AHOYbeQCzGO2k8lfzLqxjpB+LRSzlTUyTshkjYw1gmyRQB+LbmQ9Q8NkJjL6mCzaglbmCMxjsoxAH5NlBNDKpgYOcRIcgTvMKrSp5zigjXcE0E4lfnX8sUKV2RJsZWYbSF8qsyXYxivxPgJoZWYL2hS0HrSTWCNwqCvrY5wzyDY0oE2Zx5L6GI91dRGBJYIsIoBWFhFAK4sIoAXtJCKCA+0k0hdoZekLtCq0/gwwEdoOXiloE85wIKtCe4GWJtg2fFhRhPYIKQ3aHk4atB5KIrQw0qBtIKRBG+CjQcuIIEK7h40ELaFAhJaC1aA9wUSClnlWgtbhA3W1H5z3bgArQgh9i34C/OG8y2bNG8gAAAAASUVORK5CYII=";
    public static final String LEFT_ARROW_BASE64 = "iVBORw0KGgoAAAANSUhEUgAAAVgAAACoCAMAAACSVwbfAAAASFBMVEUAAAD////////////////////////////////////////////////////////////////////////////////////////////neHiwAAAAGHRSTlMAYV43PDJAREhkLkxaU1dQKygEDCIWEh1HDGJBAAAIZUlEQVR42uyc25KrIBBFEY0QQYxEzf//6eES4qVhzBinTkV7qXHepmpV1+4GTQiCIAiC/Dd0JTPREWRveGap7wTZlS57UqDaXclpMCsrguxHkRmechVG7X50lGYjHPNgL3Tmwajdm5pmM+obQfbqXgGM2h15UJpRzIP90VmEa45qd1p6YR7sTpVlIA2u1+yqeoJ8Qm+tAoxZjNoPkU4sVGu4aIJshtNYxXpUS5Ct3Kgxm1aLebCVu9UK3F5faktUuxEZ0+obmINeCLKFIniFYYBR+wkdtcTFBhjmwe/RfoGQMotRuxmRGAvmZiXmwW/J4yVrvaLaT+gTGevUYh5sR0uagX0Ye0XIcZX7CzgQG/RCuRLNvk+VXNVGqhaXC+8yVAKKTaeBJMg6us8VNaTHAuCWEmQF3XJv9Rmx7rbYL4AIgvxEXwk6w5p9JwvwkU0a3V+UpFJOpNoLEBNbEiQVAExJA6WSjoBN2ZRZXCIkAoBJi5EKSE1cOGyt0V8aGaDQbWaOtXpVuDxYoB95PZVqgRVL1zYMcBtmGavB6k8lu74pqwjy4t6WM6GhZClQC0ZZB3auGP2tVErJJdQLXulgQGxBkOcaQFmkkvYMUJAEb85bFAvWWa3VC6lgwYY8WItZHLVGdF81aoaERJsXNHt1B3YuazVv1BwJ1fqSBWQ0PW+d+pVZ3Vmr0CuwGtxO5K5sFzByWnRXNnWtzAkwGhdyYcgm92XPPWo5qx6lgNrgFQ4GcrV7nXnU0g9vVdkzotUc0blgIlYW6Y2Y7Jyvc+pHIeqA8gdAQqg/LazqCalDEsANrhN2Lt3non6hgts61r7MDc6yVJWdJpY83cHONmrp/hKsziv27ZJtLj0JPNJeswc5EUMlGqDVnXGvIGVZOwtOHbSCl2LO1LmsVYM12wC1ajkaSDAZ1EWnyQKeKtnTjFpPq7X7iFWttzoTO7N66TWBVIl17Uk2Ce4taxzeKmQlZe0EEKdPPKE5w6il26IJhKJNdy8Ys2X7gySt4llw+FFLd0UDANUaPoHXOsxVSXj00VdNDo3uCy4aAIgDNR5T6hzEKqSNTrIDOTDDjQshGnvBkgVJu/RqmtV7/yX2uPbAo9bQcmFp7Dlz6j6A2lCw3q249eRdYiF71M6l21xYvNR4GMCUdVLNrYxZTVN4rdOaPebvnOkuWJ1WLBTbgLWXt/rbauvGLDhy5xoqPnWaytg4Zas3fZfOc+BRy7YrUK2JigVy7WC1iXrh9WhvGZtg5SKIHdUCs1DsdqvTrcNjdi7d59wxt+q1roVBYa1upw9RQA83ag0tc1K91rnbIBcU7MdWYcjSQ/1er+4KzoNXQIgCCLC6GUY9Rxq1xggIl+CL5uX/gBkLrG6melXsUUYtGwEO8fwQ5khU7EItsLpDyB5k1NKPnAe8UneaayFVgNVX0WqyJ/KVst///ZhhYtUbjadsSIIxDFi7e3spQxJ8+0ub965kjC8Q7kioDYh2IPvT0idfPWqZCGCccXMCnFhAE9zy20D+hDt1fPWoNbQlMyy8iknB8vjAxS97W4XPar+2c+nHhVm4PWaIcBPRKOBFr8kfMtTfHATDrWSBSBaIpF4wWu3PvWDld9ar7nI2wn3vYrB/QastfjEwzXBhU7g1y5ZRIKBZ3h76qd7nmwFsyVivMGpfViu0+q+dc9lxFAai6MIPRl7ZwSH//6cT2/IUuAooED2ake6BkP3R1XXZdEcVVmoBatmhB1aZNR9UwGFYvZ94XuvFEktaDYr1OKy+IHttD4LOYKaMCjgeA4rUcnW4X87kYPWIJVlfqG69oLR+sTowGRVwuMEKXWq7yk00qTywU/6Pt+p/gSVb32lWC3LLktwJs9Uhr6WFlbxSz/KhCxVwYboaaGZHqRRaVMA5S7CS0/q1yy+DCjg7EbTkdawD7rNl1mF7dbpgffHWS5ltYjkeJywnzKFb5aFtTcDaAGHVvMKyBdkrzbIbPNarE+ZkmtUdt5PgFbtWzRzQ8YeJbV8Vj5FV2QGEFxqW3CKsKuZstk7JrDjMIqwq5mgtjyuZlYYuhFXVAd9bSGzzK5SBRVg1HUBaeWSFnkWzajrAGCsHlo8GCKv+5wNNpXotT0IuAjSr7pjlj1ShDDzdCOu1aq1Yiqykdp1ZvBNQVWunV4DcA/32FqcBumrtWGpZIbc9sAFHV8pqJWgqMIPSHlcb0QGnzFwr9YHcswirQmviYa3PPhkwAppVpZXTtMqRxYKlqtZgjNsxK5Ys3rXoVizXvDoe1l6xBh1wR2u5diNbIbP4I2FdtbpGSyyTa8dNQoRWpVaKq5MDu66DiA5QsCRHUMcStj/RAXpe70hSu1aO7Q/MAUqtYW21QhXL97QGHaDXSlDN8pGr4LAXUO4GVkqbVepYDqpVxZxXWsc6ENTGN7SqtDrulaYCelRQrfq0BtFrK4N2EZgDrmgNX7hWWrwctF5jyVVpu0YM3aaRFmhV8FpSCEwsV9vnrYRqVW6yQseVe6di+xYBU+s1rZRX2Wyzileu17V2t0VtEKvAYcW6pJUnlnst4D+G9Fo5rnwksGLptca4NUq5HcEgoNdarLLIymKxYqm1plhhZl39DFpxzqJk0MrdQuvttBJjC4TNWBCxddWnlaDli7ktavFm4KpWIuyvXgFaL2slZKshQOslrYkFNg5WOx9oVbKk4jUNXsuHq8XYqueTKjGm0zLA68EbXs9LFmPrtR5oiC2LtN7mlbvXKIQWWm+zJGJ/+cJp652GJXgVRGi9ycZrYmK/N35W+AGxrGSxyXpCbIoj0HqbnAhofZB32gKtDzGnDdD6GFnyigOsxyOboPUplrXUBK0/tH5B64O8MrT+EPP7k3N+QysAAIB/nN/xxBhB+nlfAwAAAABJRU5ErkJggg==";
    public static final int LEFT_ARROW_CLIP_START_ANGLE = -118;
    public static final int LEFT_ARROW_CLIP_SWEEP_ANGLE = 13;
    public static final String RIGHT_ARROW_BASE64 = "iVBORw0KGgoAAAANSUhEUgAAAVgAAACoCAMAAACSVwbfAAAASFBMVEUAAAD////////////////////////////////////////////////////////////////////////////////////////////neHiwAAAAGHRSTlMAYDI3ZEMtO1EpXVlVTT9HSgoGGRAjFR6TuMrAAAAIfElEQVR42uyb3RaqIBBGwZ8kkEDNfP83PXCgIAY7ZrbWSWeLXnax16yPYTSCIAiC/EecJW0LgmzMoKilIciWdDX1DATZjL4Q9E5JkK0YW0pR7OYMmsZMBNmCvqHPdATZIlw5rWiMJMjnDC5cK4zYTbnqyCp2W1vRl8apWQkE+YwTpzRjVhHkEwbmnALOBFlPp63T6nFFXAnyQYtVVTRfsYIg68O1ssBqtdQEWcegvVZqbthtjQRZQ3e5Fyv1KYvn2a3C1eOtJmYZQd5nElWAViAHOL4+WMMgI6dRV4Ajw4/oyypiNmJ7grxFQYFXt/A8+wmDqBLifQtHhivpZJXzmutibwRZGa5JG/sEx/PscjpRQcK2VWHEruRSeaBZULA4MnwDCmMgOE3VyjMODZdSBWDJJnADa/Cd1yJk1ipMWAv31COOYv7JAKyGSSzQam6PLLDzeqtkqa/XChas0xpgDQ4OXtFV+T52vmID4oKhME+RseofKc9Whb1FjZ3CDD0FWWAWgNsLIgyyxMDNccrmQPVvrYILs7zbCSeKAB2cxvGauk0RXqsHA/dly0Vp/nTAab5irdwAdrjP1CAIADyv1T1jFG5mgY7HO5e70nqlcwEL1LZ4eoAtl9+3IKBezXIXVNu2LTYKjr59GnBDtTyDAFa9VtFatxrdGsY4ZPMTmBThr0SrM2uWgZU4CtPOah4OEWZBvFtfs+g2armivWtZF8sTqQanVLSegx8e4q/hIK+6WB60hoxNaI7rtufUec2+7eINS2OAuwsk7P1KOWzdFrBgg1dJyPWk4m3Lr9SsMwphluKQedu3/tSV2uWPT2C68dJyS2x2risIMOu1ZVauPKLbwVVsDh5a0lvJvFaebQi8VgizZo/pVoOEdfDkK8PruY7mBDwp1ly+Wqf29qiDnXlvMGLdGJYqEuNDIX/ssm5BybKDuy2z7735zCcwUymhVpFPgthqcHuYOVjPnVIwiL3N1Xih84cuGAVuJaijzG/PuSHB668Mu3OdmnUrqVZ75bhMh3Ars2eumrykG5t4sPUM82pnvErJZHMAtwN8ibjoX3P9VDJXrrNZkMSstMs+/rL/UY3OHLv4soK6ldJqhUlwPx7MlqxF77xN6AQUy5Y3bIXMZgEL9RqQ7iEf1LtuEwoYsQ15g2uhgNaWzWk13B+WPcdtL8C0cHq36kcFjl3QrZVpH/YZsd/p7RmUbL8iUaYLbGIBUto7VavVaZ9xq5KKlcSx2i3L9gS+ZAFaaq3r0w4jYUgKtiSGtW7Zq4LNqtWeHcZt8yx2IJb1buN0BX1stmDvcoudfdrciacPYD7+ualxYQA7LRcHQGygPu2qAytogCsCWOU2wVuF6ITLsJ9I6Nto7zoTx+ZupctYkAQAtZ93DlMk9rpdxEy1M/oiYUHJKnupy166BPX4mwzbNr7HOj4e5JuCGGWWo9lFJAyPgq3JxnQnda/YmaYAuFWePexkpffKR7I918K4nUvYRK3xaR+ey/nXy7YXzivvyFe4FXXGqzY3QD3x8ztZ4cRK8jWGQksI9ApofrtsFeeUi458kX4qYUsAEzahNpTDD4/ARqW+3+R0UxOrzXkF1NYt/iNySQsWmwVbV8arU7uPBuyrXE/W7ezWBbVasGwXcTsp6xWqzSYBlu2fds5u520QCKKfFhWLG1e2Y+f937QQ1oUwRIKERko6xyS+PxoNa/LTt5WVTuOVOc0jy9h2nSYUaoEY1swtY9tctymwqDYqjXIZ2+66fZBXLALGto9lMzexdbUpsIxtP4udVStuXnXm2S/55Eeyd3GxvytoF+R6Z/UazM7ms08S3sOyTYXUAIY2KL29+eX59AOw8dQrIbfqbyj1dJsw/8tXxV/iEDULIyykdk5wI2uuBBhhQew95mBsmx4cdNSKfqELvMnC7eQbgTMCAKyb/IIhFtTmTNM8fek3FwezuOlRDUBeT7eTHIxtA5vcb1+zX3pDp+eLjdDCsk+1wKJYv8IVYCO0cdhiyvJ3UDtlmWUjdAxgpdu5RJXqjY3QysWp1noVTNqyChuhO7baBTMwnZfCRuiNLTZBSivCp4Y2lqsBrZjYHGN4jtDGITWrmlnUavzry3+5O4zFmVpea2qD1oB86y8gR7NJobXq1fhlpttlWLbtJwlFXgGjkVX4MU4j62ayGRa3LtWa1LJsO+avGFf/XidqzXLLybb9SwkT5BUSm2DZtrPZ4LUeV1338MPHjvmrplalYmjFOJZtG8th0Ks2AWoNL57QtG9kNbHJKqrlF5QaWXaZcrQEHrsV7mONrHkjGL3AaVweqn2iEYJhDSuqjXLlBp/H2hvBaBGcgUWnnhDYaJf7WPuMIKkMAI1rWCecvpo5XHCqr6rZQu2FZdvIuutjFzaBFmyhlke2raxXMRVENK4lPA1v5xBogYBoZKn2eS57YVXi5RdiRb7vL+uAgWWbUxQsquXZV3/Zyv2zgUGtYQk/MH+qbFUtWr15jRfVtnNxKbHJqincUu0rZSsPE2tPt9ZSbZdaezZsuCHJLNX2sR72bxOYWmTVqtgbfNLt4LA4bEWh2S2p5efl7Rwuf/DCreuEartZrpKAJogr4fjpWDvrFeMqDyLrXzxE6FFrC7OwdzG1T48I2AV1rX5RbQ8Xl/Ka2UWzzjqqfUatvXcqhVZn/UW1fSx7/tClM0GBC8tRbff0pUWgSrEHtAuo9pnpy9pzIbEKqPZJtVnJYhPk7PwiQt9gqwimNawc/ilVD+vmHhYBzb7EejgbwFmrhIe1/YMt9muN/Ye8qjbAyI5RC1UQ7mzZwWr9xS4Yp3ZPga3zQ15R65hYZahaNcuxYLxap3DzepNa/txmgFo2gTJeLQOr/Gu1/AXTQLV8ngVGq+UvFQazHNd9v/J/1gkh5D38AZv7Cqq3NfC/AAAAAElFTkSuQmCC";
    public static final int RIGHT_ARROW_CLIP_START_ANGLE = -62;
    public static final int RIGHT_ARROW_CLIP_SWEEP_ANGLE = -13;
    private static final String TAG = "ArrowLayer";
    private final String mArrowBase64;
    private BitmapLayer mArrowLayer;
    private final float mContainerHeight;
    private final float mContainerWidth;
    private final String mFillArrowBase64;
    private BitmapLayer mFillArrowLayer;
    private final float mStartAngle;
    private final float mSweepAngle;

    public CNYTwistArrowLayer(Context context, String str, String str2, float f16, float f17, float f18, float f19) {
        super(new AnimatorLayer[0]);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, str2, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        this.mArrowBase64 = str;
        this.mFillArrowBase64 = str2;
        this.mContainerWidth = f16;
        this.mContainerHeight = f17;
        this.mStartAngle = f18;
        this.mSweepAngle = f19;
        int relativeSize = getRelativeSize(context, 86);
        int relativeSize2 = getRelativeSize(context, 42);
        setWidth(relativeSize);
        setHeight(relativeSize2);
        initArrowLayers(context);
    }

    private int getRelativeSize(Context context, int i3) {
        if (context == null) {
            Logger.e(TAG, "getRelativeSize, context is null, return origin size");
            return i3;
        }
        return Utils.getRelativeSize375(context, i3);
    }

    private void initArrowLayers(Context context) {
        int width = getWidth();
        int height = getHeight();
        float x16 = getX() - 4.0f;
        float y16 = getY();
        Bitmap bitmapFromBase64StringSafe = Utils.bitmapFromBase64StringSafe(this.mArrowBase64, width, height);
        if (bitmapFromBase64StringSafe != null) {
            BitmapLayer bitmapLayer = new BitmapLayer(bitmapFromBase64StringSafe);
            this.mArrowLayer = bitmapLayer;
            bitmapLayer.setX(x16);
            this.mArrowLayer.setY(y16);
            this.mArrowLayer.setWidth(width);
            this.mArrowLayer.setHeight(height);
            BitmapLayer bitmapLayer2 = this.mArrowLayer;
            bitmapLayer2.setAnimator(new KeepAnimator(bitmapLayer2));
            addLayer(this.mArrowLayer);
        } else {
            Logger.e(TAG, "initArrowLayers, arrowBitmap is null");
        }
        Bitmap bitmapFromBase64StringSafe2 = Utils.bitmapFromBase64StringSafe(this.mFillArrowBase64, width, height);
        if (bitmapFromBase64StringSafe2 != null) {
            ArcClipBitmapLayer arcClipBitmapLayer = new ArcClipBitmapLayer(bitmapFromBase64StringSafe2, getRelativeSize(context, 411), this.mContainerWidth / 2.0f, this.mContainerHeight - getRelativeSize(context, CLIP_ARC_CENTER_MARGIN_BOTTOM), this.mStartAngle, this.mSweepAngle);
            this.mFillArrowLayer = arcClipBitmapLayer;
            arcClipBitmapLayer.setX(x16);
            this.mFillArrowLayer.setY(y16);
            this.mFillArrowLayer.setWidth(width);
            this.mFillArrowLayer.setHeight(height);
            BitmapLayer bitmapLayer3 = this.mFillArrowLayer;
            bitmapLayer3.setAnimator(new KeepAnimator(bitmapLayer3));
            addLayer(this.mFillArrowLayer);
            return;
        }
        Logger.e(TAG, "initArrowLayers, fillArrowBitmap is null");
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public AnimatorLayer setX(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
        }
        BitmapLayer bitmapLayer = this.mArrowLayer;
        if (bitmapLayer != null) {
            bitmapLayer.setX(f16);
        } else {
            Logger.e(TAG, "setX, arrowLayer is null");
        }
        BitmapLayer bitmapLayer2 = this.mFillArrowLayer;
        if (bitmapLayer2 != null) {
            bitmapLayer2.setX(f16);
        } else {
            Logger.e(TAG, "setX, fillArrowLayer is null");
        }
        return super.setX(f16);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public AnimatorLayer setY(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
        }
        BitmapLayer bitmapLayer = this.mArrowLayer;
        if (bitmapLayer != null) {
            bitmapLayer.setY(f16);
        } else {
            Logger.e(TAG, "arrowLayer is null");
        }
        BitmapLayer bitmapLayer2 = this.mFillArrowLayer;
        if (bitmapLayer2 != null) {
            bitmapLayer2.setY(f16);
        } else {
            Logger.e(TAG, "fillArrowLayer is null");
        }
        return super.setY(f16);
    }
}
